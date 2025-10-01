package lab8_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab8_3GUI {
    
    // ตัวแปรสำหรับนับจำนวนครั้งที่ปุ่มถูกกด ต้องเป็น static เพื่อให้ Anonymous Inner Class เข้าถึงได้
    private static int clickCount = 0; 

    public static void main(String[] args) {
        
        // 1. สร้าง JFrame
        JFrame frame = new JFrame("Test");
        
        // 2. สร้าง JButton และกำหนดข้อความเริ่มต้น
        JButton jb = new JButton("click (0)"); 
        
        // 3. จัด Layout โดยใช้ JPanel
        JPanel center = new JPanel();
        center.add(jb);
        
        // เพิ่ม JPanel เข้าไปใน JFrame
        frame.getContentPane().add(center, BorderLayout.CENTER);
        
        // ตั้งค่าให้ปิดโปรแกรมเมื่อปิดหน้าต่าง
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ******* การเพิ่ม Event Handling ด้วย Anonymous Inner Class *******
        // เรียกใช้เมธอด addActionListener โดยส่ง Anonymous Inner Class เข้าไป
        jb.addActionListener(new ActionListener() {
            
            // เมธอดนี้จะถูกเรียกเมื่อปุ่มถูกคลิก
            @Override
            public void actionPerformed(ActionEvent e) {
                // เพิ่มค่านับ
                clickCount++; 
                
                // เปลี่ยนข้อความบนปุ่มเพื่อแสดงผลการนับ
                jb.setText("click (" + clickCount + ")");
            }
        });
        
        // ปรับขนาดหน้าต่างให้พอดีกับส่วนประกอบ และแสดงหน้าต่าง
        frame.pack();
        frame.setVisible(true); 
    }
}
