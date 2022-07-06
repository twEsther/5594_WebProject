package wefly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int len = 6, width = 16 * 2 + 12 * len, height = 20;
	
    @Override 
	public void init() {
		String len = this.getInitParameter("len");
		if(len!=null && len.matches("\\d+")) {
			this.len = Integer.parseInt(len);
			this.width = 16 * 2 + 12 * this.len;
		}
	}

    private BufferedImage generateImage(String captcha, int width, int height) {

        //開始建立圖片  //這裡繪製圖片的程式如果有錯都是要import awt的

        BufferedImage image =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();   //取得影像繪圖區 把Graphics當作是一支筆

       //畫出背景方塊
        g.setColor(getRandomColor(200, 250)); //設定繪圖區背景色；數字越大顏色越淺
        g.fillRect(0, 0, width, height);    //在繪圖區畫個長方型；fillRect會畫在image上
 
        //畫干擾線讓背景雜亂
        Random random = new Random();
        g.setColor(getRandomColor(170, 210));
        for (int i = 0; i < 155; i++) {

            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);

            g.drawLine(x, y, x + xl, y + yl);

        }

        //畫出認證文字，這裡的每個字元也可以分開來設定顏色之類的
        g.setFont(new Font("Arial", Font.PLAIN, 18));//設定字體
        g.setColor(getRandomColor(20, 140));

        //將認證文字畫到image中
        g.drawString(captcha, 16, 16);
        g.dispose();

        return image;

    }

    private Color getRandomColor(int fc, int bc) {

        //在參數設定的範圍內，隨機產生顏色

        Random random = new Random();

        if (fc > 255) fc = 255;

        if (bc > 255) bc = 255;

        int r = fc + random.nextInt(bc - fc);

        int g = fc + random.nextInt(bc - fc);

        int b = fc + random.nextInt(bc - fc);

        return new Color(r, g, b);

    }
    
    
    
    
    
    public CaptchaServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String captcha = "";
		Random random = new Random();
		for(int i=0;i<len;i++) {
			int data = random.nextInt(36);
			char ch = (char)(data<10?(data+'0'):(data-10+'A'));//這段是怎樣???
			
			captcha += ch;
		}

		HttpSession session = request.getSession();
		session.setAttribute(this.getServletName(), captcha);

		
		
		//把字串繪製成圖片，算是這邊的商業邏輯(Draw Image)
		BufferedImage image = generateImage(captcha, width, height);
		
		
		//3. 輸出圖片
        response.setContentType("image/jpeg");
        
        //位元串流不用設定編碼方式
        try (ServletOutputStream outStream = response.getOutputStream();){      //將影像輸出到頁面
            ImageIO.write(image, "JPEG", outStream);
		
        }
	}
}
