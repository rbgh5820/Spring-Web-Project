using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;
using System.IO;
using log4net;
using log4net.Config;
using OpenCvSharp;
using OpenCvSharp.Extensions;

[assembly: log4net.Config.XmlConfigurator(ConfigFile = "log4net")]

namespace 캠_불러오기
{
    public partial class Form1 : Form
    {

        private static readonly log4net.ILog log = log4net.LogManager.GetLogger(typeof(Form1));

        public UdpClient newsock = null;
        public IPEndPoint iPEndPoint = null;
        int pos = 0;
        int nImgSize = 0;

        Thread th;
        bool receiveCheck;
        public Form1()
        {
            InitializeComponent();

            IPEndPoint ipep = new IPEndPoint(IPAddress.Any, 8888);
            newsock = new UdpClient(ipep);
            iPEndPoint = new IPEndPoint(IPAddress.Any, 0);

            XmlConfigurator.Configure(new System.IO.FileInfo("log4net.xml"));
        }

        private void button1_Click(object sender, EventArgs e)
        {
            th = new Thread(receive);
            th.Start();


            /*FileStream fs = File.OpenRead(@"C://test//byte2Test");

            byte[] data = new byte[fs.Length]; // fs에 파일의 크기만큼 data 배열에 담는다

            fs.Read(data, 0, data.Length); 
            fs.Close();

            this.pictureBoxIpl1.Image = byteArrayToImage(data); // byte배열 파일로 저장된것을 이미지로 변환
            pictureBoxIpl1.SizeMode = PictureBoxSizeMode.StretchImage; // picture박스 크기에 맞게 이미지 사이즈 조절*/
        }

        private void receive()
        {
            receiveCheck = true;

            byte[] receivedata = new byte[1000 * 1000]; // 이미지를 담을 data 그릇
            byte[] imageSize = new byte[4]; // imageSize = 4byte 
            byte[] imageData = null;

            while (receiveCheck)
            {
                byte[] temp = newsock.Receive(ref iPEndPoint); // 클라이언트에서 Receive해온걸 temp 바이트에 저장
                int tempSize = temp.Length;
                if (tempSize < 4)
                {
                    continue;
                }
                else // tempsize가 4바이트를 넘으면 
                {
                    Buffer.BlockCopy(temp, 0, receivedata, pos, tempSize); // temp에 0번째부터 tempsize만큼 receivedata의 pos지점부터 복사
                    pos += tempSize; // pos = pos+tempsize = 4byte;
                    log.Debug("pos : " + pos); // 로그

                    if (nImgSize == 0)
                    {
                        Buffer.BlockCopy(temp, 0, imageSize, 0, 4); // 4byte만큼 imageSize에 복사
                        nImgSize = BitConverter.ToInt32(imageSize, 0); //imageSize를 int로 변환
                        log.Debug("nImgSize : " + nImgSize);
                    }
                    else
                    {
                        if (nImgSize == (pos - 4))
                        {
                            imageData = new byte[nImgSize]; // mImgsize !== 0일경우 imageData는 nImgSize만큼 데이터를 담는다
                            Buffer.BlockCopy(receivedata, 4, imageData, 0, nImgSize); // pos = 4byte이므로 receivedata 는 4바이트째부터 nImgSize만큼 imageData에 복사

                            this.pictureBoxIpl1.ImageIpl = ConvertToImage(imageData);
                            this.pictureBoxIpl1.Image = byteArrayToImage(imageData);// 픽쳐박스에 이미지를 띄우기
                             //File.WriteAllBytes("J://Image.jpg", imageData);
                            break; 
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
            }
        }

        private IplImage ConvertToImage(byte[] imageData)
        {
            IplImage iplimage = new Bitmap(imageData.ToIplImage());

            return iplimage;
        }

        private Image byteArrayToImage(byte[] data)
        {
            MemoryStream ms = new MemoryStream(data);
            Image returnImage = Image.FromStream(ms);
            return returnImage;
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            receiveCheck = false;
        }
    }
}