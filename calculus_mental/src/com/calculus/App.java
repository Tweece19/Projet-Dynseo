package com.calculus;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class App {
    static JTextField level = new JTextField("Dificulty lv 1");
    static JTextField calcul = new JTextField("");
    static JButton button1 = new JButton("Test");
    static JButton button2 = new JButton("Test");
    static JButton button3 = new JButton("Test");
    static JButton button4 = new JButton("Test");
    static JTextField response = new JTextField("");
    static int res_place = 0;
    static Random r = new Random();
    static int cpt_lvl = 0;

    public static String Operator(int op) {
        if (op == 0)
            return "+";
        else if (op == 1)
            return "-";
        else if (op == 2)
            return "*";
        else
            return ":";
    }

    public static int ResOp(int t1, int t2, String op) {
        if (op.equals("+"))
            return t1 + t2;
        else if (op.equals("-"))
            return t1 - t2;
        else if (op.equals("*"))
            return t1 * t2;
        else
            return t1 / t2;
    }

    public static boolean contains(int[] arr, int test) {
        boolean res = false;
        for (int i : arr) {
            if (i == test) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static void SetOthButton(int bound, int dec) {
        int[] propals = new int[4];
        propals[0] = bound;
        if (res_place != 1) {
            int propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            while (contains(propals, propal))
                propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            propals[1] = propal;
            button1.setText(String.valueOf(propal));
        }
        if (res_place != 2) {
            int propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            while (contains(propals, propal))
                propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            propals[2] = propal;
            button2.setText(String.valueOf(propal));
        }
        if (res_place != 3) {
            int propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            while (contains(propals, propal))
                propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            propals[3] = propal;
            button3.setText(String.valueOf(propal));
        }
        if (res_place != 4) {
            int propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            while (contains(propals, propal))
                propal = r.nextInt((bound + dec) - (bound - dec)) + (bound - dec);
            button4.setText(String.valueOf(propal));
        }
    }

    public static int FindDiviser(int dividende) {
        int res = r.nextInt((dividende + 1) - 2) + 2;
        while (dividende % res != 0) {
            res = r.nextInt((dividende + 1) - 2) + 2;
        }
        return res;
    }

    public static void Level3() {
        cpt_lvl++;
        level.setText("Difficulty level 3");

        int op = r.nextInt(4);
        String operator = Operator(op);
        int t1 = r.nextInt(101);
        int t2 = r.nextInt(101);

        if (operator.equals("*") && t1 > 10) {
            t2 = r.nextInt(10);
        }
        if (operator.equals(":")) {
            if (t1 < t2) {
                t1 = t2;
            }
            t2 = FindDiviser(t1);
        }

        int response = ResOp(t1, t2, operator);
        calcul.setText(t1 + operator + t2);
        switch (res_place) {
            case 1:
                button1.setText(String.valueOf(response));
                break;
            case 2:
                button2.setText(String.valueOf(response));
                break;
            case 3:
                button3.setText(String.valueOf(response));
                break;
            case 4:
                button4.setText(String.valueOf(response));
                break;
            default:
                break;
        }

        SetOthButton(response, 10);
    }

    public static void Level2() {
        cpt_lvl++;
        level.setText("Difficulty level 2");

        int op = r.nextInt(4);
        String operator = Operator(op);
        int t1 = r.nextInt(21);
        int t2 = r.nextInt(21);

        if (operator.equals("*") && t1 > 10) {
            t2 = r.nextInt(11);
        }
        if (operator.equals(":")) {
            if (t1 < t2) {
                t1 = t2;
            }
            t2 = FindDiviser(t1);
        }

        int response = ResOp(t1, t2, operator);
        calcul.setText(t1 + operator + t2);
        switch (res_place) {
            case 1:
                button1.setText(String.valueOf(response));
                break;
            case 2:
                button2.setText(String.valueOf(response));
                break;
            case 3:
                button3.setText(String.valueOf(response));
                break;
            case 4:
                button4.setText(String.valueOf(response));
                break;
            default:
                break;
        }

        SetOthButton(response, 10);
    }

    public static void Level1() {
        cpt_lvl++;
        level.setText("Difficulty level 1");
        int t1 = r.nextInt(21);
        int t2 = r.nextInt(21);
        int op = r.nextInt(2);
        String operator = Operator(op);
        int response = ResOp(t1, t2, operator);
        calcul.setText(t1 + operator + t2);
        switch (res_place) {
            case 1:
                button1.setText(String.valueOf(response));
                break;
            case 2:
                button2.setText(String.valueOf(response));
                break;
            case 3:
                button3.setText(String.valueOf(response));
                break;
            case 4:
                button4.setText(String.valueOf(response));
                break;
            default:
                break;
        }
        SetOthButton(response, 10);
    }

    public static void ReInit() {
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        button4.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculus");

        Font levelfont = new Font("Arial", Font.BOLD, 30);
        Font calculFont = new Font("Arial", Font.BOLD, 25);
        Font buttonFont = new Font("Arial", Font.BOLD, 40);
        Font responseFont = new Font("Arial", Font.BOLD, 50);
        LineBorder textBorder = new LineBorder(Color.WHITE, 1);
        LineBorder buttonBorder = new LineBorder(Color.BLACK, 5);

        level.setBounds(20, 40, 360, 40);
        level.setHorizontalAlignment(JTextField.CENTER);
        level.setBackground(Color.WHITE);
        level.setBorder(textBorder);
        level.setEditable(false);
        level.getCaret().setVisible(false);
        level.setCaretColor(Color.WHITE);
        level.setFont(levelfont);

        calcul.setBounds(30, 100, 340, 25);
        calcul.setHorizontalAlignment(JTextField.CENTER);
        calcul.setBackground(Color.WHITE);
        calcul.setBorder(textBorder);
        calcul.setEditable(false);
        calcul.getCaret().setVisible(false);
        calcul.setCaretColor(Color.WHITE);
        calcul.setFont(calculFont);

        button1.setBounds(10, 180, 180, 60);
        button1.setHorizontalAlignment(JButton.CENTER);
        button1.setBackground(Color.WHITE);
        button1.setBorder(buttonBorder);
        button1.setFont(buttonFont);

        button2.setBounds(210, 180, 180, 60);
        button2.setHorizontalAlignment(JButton.CENTER);
        button2.setBackground(Color.WHITE);
        button2.setBorder(buttonBorder);
        button2.setFont(buttonFont);


        button3.setBounds(10, 260, 180, 60);
        button3.setHorizontalAlignment(JButton.CENTER);
        button3.setBackground(Color.WHITE);
        button3.setBorder(buttonBorder);
        button3.setFont(buttonFont);


        button4.setBounds(210, 260, 180, 60);
        button4.setHorizontalAlignment(JButton.CENTER);
        button4.setBackground(Color.WHITE);
        button4.setBorder(buttonBorder);
        button4.setFont(buttonFont);


        response.setBounds(25, 400, 340, 50);
        response.setHorizontalAlignment(JTextField.CENTER);
        response.setBackground(Color.WHITE);
        response.setBorder(textBorder);
        response.setEditable(false);
        response.getCaret().setVisible(false);
        response.setCaretColor(Color.WHITE);
        response.setFont(responseFont);

        res_place = r.nextInt(4) + 1;

        button1.addActionListener(event -> {
            if (res_place == 1) {
                response.setText("Vrai");
                res_place = r.nextInt(4) + 1;
                if (cpt_lvl < 10)
                    Level1();
                else if (cpt_lvl < 25)
                    Level2();
                else
                    Level3();
                ReInit();
            } else {
                button1.setBackground(Color.RED);
                response.setText("False");
            }
        });

        button2.addActionListener(event -> {
            if (res_place == 2) {
                response.setText("Vrai");
                res_place = r.nextInt(4) + 1;
                if (cpt_lvl < 10)
                    Level1();
                else if (cpt_lvl < 25)
                    Level2();
                else
                    Level3();
                ReInit();
            } else {
                button2.setBackground(Color.RED);
                response.setText("False");
            }
        });

        button3.addActionListener(event -> {
            if (res_place == 3) {
                response.setText("Vrai");
                res_place = r.nextInt(4) + 1;
                if (cpt_lvl < 10)
                    Level1();
                else if (cpt_lvl < 25)
                    Level2();
                else
                    Level3();
                ReInit();
            } else {
                button3.setBackground(Color.RED);
                response.setText("False");
            }
        });

        button4.addActionListener(event -> {
            if (res_place == 4) {
                response.setText("Vrai");
                res_place = r.nextInt(4) + 1;
                if (cpt_lvl < 10)
                    Level1();
                else if (cpt_lvl < 25)
                    Level2();
                else
                    Level3();
                ReInit();
            } else {
                button4.setBackground(Color.RED);
                response.setText("False");
            }
        });

        Level1();

        frame.add(level);
        frame.add(calcul);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(response);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(new Dimension(400, 600));
        frame.getContentPane().setBackground(Color.WHITE);
    }
}
