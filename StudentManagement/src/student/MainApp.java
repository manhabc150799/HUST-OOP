/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author Admin
 */
import javax.swing.JFrame;

public class MainApp {
    public static void main(String[] args) {
        // Đảm bảo GUI chạy đúng luồng
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Home Panel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1540,900);// chỉnh theo giao diện bạn thiết kế

                // Gắn JPanel thiết kế vào JFrame
                frame.setContentPane(new Home());

                frame.setVisible(true);
            }
        });
    }
}
