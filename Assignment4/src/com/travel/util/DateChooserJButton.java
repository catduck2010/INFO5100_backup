package com.travel.util;

/**
 * <code>DataChooserJButton</code>
 * 
 * <p>
 * @author @version 1.0, 2005-6-7
 */
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;

public class DateChooserJButton extends JButton {

    private DateChooser dateChooser = null;
    private Frame ans = null;
    private String preLabel = "";

    public DateChooserJButton() {
        this(getNowDate());
    }

    public DateChooserJButton(SimpleDateFormat df, String dateString) {
        this();
        setText(df, dateString);
    }

    public DateChooserJButton(Date date) {
        this("", date);
    }

    public DateChooserJButton(String preLabel, Date date) {
        if (preLabel != null) {
            this.preLabel = preLabel;
        }
        setDate(date);
        setBorder(null);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        super.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser == null) {
                    dateChooser = new DateChooser();
                }
                Point p = getLocationOnScreen();
                p.y = p.y + 30;
                dateChooser.showDateChooser(p);
            }
        });
    }

    private static Date getNowDate() {
        return Calendar.getInstance().getTime();
    }

    private static SimpleDateFormat getDefaultDateFormat() {
        return new SimpleDateFormat("MM/dd/yyyy");
    }

    @Override
    public void setText(String s) {
        Date date;
        try {
            date = getDefaultDateFormat().parse(s);
        } catch (ParseException e) {
            date = getNowDate();
        }
        setDate(date);
    }

    public void setText(SimpleDateFormat df, String s) {
        Date date;
        try {
            date = df.parse(s);
        } catch (ParseException e) {
            date = getNowDate();
        }
        setDate(date);
    }

    public void setDate(Date date) {
        super.setText(preLabel + getDefaultDateFormat().format(date));
    }

    public Date getDate() {
        String dateString = getText().substring(preLabel.length());
        try {
            return getDefaultDateFormat().parse(dateString);
        } catch (ParseException e) {
            return getNowDate();
        }

    }

    public void setToday() {
        setDate(new Date());

    }

    @Override
    public void addActionListener(ActionListener listener) {
    }

    private class DateChooser extends JPanel implements ActionListener, ChangeListener {

        int startYear = 2000; //�
        int lastYear = Calendar.getInstance().get(Calendar.YEAR) + 50; //��
        int width = 230; //������
        int height = 230; //����        
        Color backGroundColor = Color.gray; //
        //��������ɫ----------------//
        Color palletTableColor = Color.white; //�
        Color todayBackColor = Color.orange; //�
        Color weekFontColor = Color.blue; //�������
        Color dateFontColor = Color.black; //�������
        Color weekendFontColor = Color.red; //�

        //��������ɫ------------------//
        Color controlLineColor = Color.getHSBColor(0.58f, 1.00f, 0.54f); //�
        Color controlTextColor = Color.white; //

        Color rbFontColor = Color.white; //RoundBox�
        Color rbBorderColor = Color.red; //RoundBox�
        Color rbButtonColor = Color.pink; //RoundBox�
        Color rbBtFontColor = Color.red; //RoundBox        
        JDialog dialog;
        JSpinner yearSpin;
        JSpinner monthSpin;
        JSpinner hourSpin;
        JButton[][] daysButton = new JButton[6][7];

        DateChooser() {
            setLayout(new BorderLayout());
            setBorder(new LineBorder(backGroundColor, 2));
            setBackground(backGroundColor);

            JPanel topYearAndMonth = createYearAndMonthPanal();
            add(topYearAndMonth, BorderLayout.NORTH);
            JPanel centerWeekAndDay = createWeekAndDayPanal();
            add(centerWeekAndDay, BorderLayout.CENTER);
            JPanel bottomToday = createTodayPanel();
            add(bottomToday, BorderLayout.SOUTH);
        }

        private JPanel createYearAndMonthPanal() {
            Calendar c = getCalendar();
            int currentYear = c.get(Calendar.YEAR);
            int currentMonth = c.get(Calendar.MONTH) + 1;
//            int currentHour =c.get(Calendar.HOUR_OF_DAY);

            JPanel result = new JPanel();
            result.setLayout(new FlowLayout());
            result.setBackground(controlLineColor);

            JLabel monthLabel = new JLabel("Month");
            monthLabel.setForeground(controlTextColor);
            result.add(monthLabel);

            monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
            monthSpin.setPreferredSize(new Dimension(50, 22));
            monthSpin.setName("Month");
            monthSpin.addChangeListener(this);
            result.add(monthSpin);

            JLabel yearLabel = new JLabel("Year");
            yearLabel.setForeground(controlTextColor);
            result.add(yearLabel);

            yearSpin = new JSpinner(new SpinnerNumberModel(currentYear,
                    startYear, lastYear, 1));
            yearSpin.setPreferredSize(new Dimension(65, 22));
            yearSpin.setName("Year");
            yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
            yearSpin.addChangeListener(this);
            result.add(yearSpin);

            //hourSpin = new JSpinner(new SpinnerNumberModel(currentHour,0,23,1));
            //hourSpin.setPreferredSize(new Dimension(35,20)) ;
            //hourSpin.setName("Hour") ;
            //hourSpin.addChangeListener(this) ;
            //result.add(hourSpin) ;
            //JLabel hourLabel = new JLabel("��");
            // hourLabel.setForeground(controlTextColor);
            //result.add(hourLabel);            
            return result;
        }

        private JPanel createWeekAndDayPanal() {
            String colname[] = {"S", "M", "T", "W", "T", "F", "S"};
            JPanel result = new JPanel();
            result.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
            result.setLayout(new GridLayout(7, 7));
            result.setBackground(Color.white);
            JLabel cell;

            for (int i = 0; i < 7; i++) {
                cell = new JLabel(colname[i]);
                cell.setHorizontalAlignment(JLabel.CENTER);
                if (i == 0 || i == 6) {
                    cell.setForeground(weekendFontColor);
                } else {
                    cell.setForeground(weekFontColor);
                }
                result.add(cell);
            }

            int actionCommandId = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    JButton numberButton = new JButton();
                    numberButton.setBorder(null);
                    numberButton.setHorizontalAlignment(SwingConstants.CENTER);
                    numberButton.setActionCommand(String.valueOf(actionCommandId));
                    numberButton.addActionListener(this);
                    numberButton.setBackground(palletTableColor);
                    numberButton.setForeground(dateFontColor);
                    if (j == 0 || j == 6) {
                        numberButton.setForeground(weekendFontColor);
                    } else {
                        numberButton.setForeground(dateFontColor);
                    }
                    daysButton[i][j] = numberButton;
                    result.add(numberButton);
                    actionCommandId++;
                }
            }
            return result;
        }
        
        // Lihang wrote this
        private JPanel createTodayPanel() {
            JPanel result = new JPanel();

            result.setBackground(Color.white);
            result.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton btnToday = new JButton();
            //Date now = getNowDate();
            btnToday.setText("Today");
            //btnToday.addChangeListener(this);
            btnToday.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setToday();
                    Calendar c = getCalendar();

                    yearSpin.setValue((Integer) c.get(Calendar.YEAR));
                    monthSpin.setValue((Integer) c.get(Calendar.MONTH) + 1);
                    repaintDaysButton();
                    flushWeekAndDay();
                    //dayColorUpdate(false);
                    dialog.setVisible(false);
                }
            });
            result.add(btnToday);
            
            JButton btnOK = new JButton();
            btnOK.setText("OK");
            btnOK.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    dialog.setVisible(false);
                }
            });
            result.add(btnOK);
            
            return result;
        }
        //end of my turn
        
        private void repaintDaysButton() {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    if (j == 0 || j == 6) {
                        daysButton[i][j].setForeground(weekendFontColor);
                    } else {
                        daysButton[i][j].setForeground(dateFontColor);
                    }
                }
            }
        }

        private JDialog createDialog(Frame owner) {
            JDialog result = new JDialog(owner, "Choose Date", true);
            result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            result.getContentPane().add(this, BorderLayout.CENTER);
            result.pack();
            result.setSize(width, height);
            return result;
        }

        protected void showDateChooser(Point position) {
            Frame owner = (Frame) SwingUtilities.getWindowAncestor(
                    DateChooserJButton.this);
            if (dialog == null || dialog.getOwner() != owner) {
                dialog = createDialog(owner);
            }
            dialog.setLocation(getAppropriateLocation(owner, position));
            flushWeekAndDay();
            dialog.setVisible(true);

        }

        protected Point getAppropriateLocation(Frame owner,
                Point position) {
            Point result = new Point(position);
            Point p = owner.getLocation();
            int offsetX = (position.x + width) - (p.x + owner.getWidth());
            int offsetY = (position.y + height) - (p.y + owner.getHeight());
            if (offsetX > 0) {
                result.x -= offsetX;
            }
            if (offsetY > 0) {
                result.y -= offsetY;
            }
            return result;

        }

        private Calendar getCalendar() {
            Calendar result = Calendar.getInstance();
            result.setTime(getDate());
            return result;
        }

        private int getSelectedYear() {
            return (Integer) yearSpin.getValue();
        }

        private int getSelectedMonth() {
            return (Integer) monthSpin.getValue();
        }
//        private int getSelectedHour() {
//            return ((Integer)hourSpin.getValue()).intValue() ;
//        }        

        private void dayColorUpdate(boolean isOldDay) {
            Calendar c = getCalendar();
            int day = c.get(Calendar.DAY_OF_MONTH);
            c.set(Calendar.DAY_OF_MONTH, 1);
            int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
            int i = actionCommandId / 7;
            int j = actionCommandId % 7;
            if (isOldDay) {
                daysButton[i][j].setForeground(dateFontColor);
            } else {
                daysButton[i][j].setForeground(todayBackColor);
            }
        }

        private void flushWeekAndDay() {
            repaintDaysButton();
            Calendar c = getCalendar();
            c.set(Calendar.DAY_OF_MONTH, 1);
            int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    String s = "";
                    if (dayNo >= 1 && dayNo <= maxDayNo) {
                        s = String.valueOf(dayNo);
                    }
                    daysButton[i][j].setText(s);
                    dayNo++;
                }
            }
            dayColorUpdate(false);
        }

        public void stateChanged(ChangeEvent e) {
            JSpinner source = (JSpinner) e.getSource();
            Calendar c = getCalendar();
//            if (source.getName().equals("Hour")) {
//                c.set(Calendar.HOUR_OF_DAY, getSelectedHour());
//                setDate(c.getTime());
//                return ;
//            }            
            dayColorUpdate(true);
            if (source.getName().equals("Year")) {
                c.set(Calendar.YEAR, getSelectedYear());
            } else if (source.getName().equals("Month")) {
                c.set(Calendar.MONTH, getSelectedMonth() - 1);
            }
            setDate(c.getTime());
            flushWeekAndDay();
        }

        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.getText().length() == 0) {
                return;
            }
            repaintDaysButton();
            dayColorUpdate(true);
            source.setForeground(todayBackColor);
            int newDay = Integer.parseInt(source.getText());
            Calendar c = getCalendar();
            c.set(Calendar.DAY_OF_MONTH, newDay);
            setDate(c.getTime());
        }
    }
}
