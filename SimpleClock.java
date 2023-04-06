//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;

        JButton militaryButton;
        JButton localGMT;

        boolean isMilitary=false;

        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;

        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(350, 220);
            this.setResizable(false);
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));

            militaryButton = new JButton("Military");
            militaryButton.addActionListener(this::militaryStandard);
            this.add(militaryButton);

            localGMT = new JButton("GMT");
            localGMT.addActionListener(this::localTime);
            this.add(localGMT);

    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.add(militaryButton);
            this.setVisible(true);
    
            setTimer();
        }

    private void localTime(ActionEvent actionEvent) {
    }

    private void militaryStandard(ActionEvent actionEvent) {
        if(isMilitary){
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            isMilitary = false;
        } else {
            timeFormat = new SimpleDateFormat("HH:mm:ss a");
            isMilitary = true;
        }
        time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);
    }

    public void setTimer() {
            while (true) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new SimpleClock();
        }
    }
