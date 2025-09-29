package test;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingUI extends JFrame {
    private BookingManager manager = new BookingManager();
    private Teacher teacher;
    private DefaultListModel<String> bookingListModel = new DefaultListModel<>();

    public BookingUI(Teacher teacher) {
        this.teacher = teacher;

        setTitle("Classroom Booking - " + teacher.getName());
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Classroom[] rooms = {
            new Classroom("Room A", 30),
            new Classroom("Room B", 50),
            new Classroom("Room C", 100)
        };

        JComboBox<Classroom> roomBox = new JComboBox<>(rooms);
        JTextField startField = new JTextField("2025-10-01T08:00");
        JTextField endField = new JTextField("2025-10-01T10:00");
        JCheckBox fullTermBox = new JCheckBox("Full Term");

        JButton bookBtn = new JButton("Book");
        JButton cancelBtn = new JButton("Cancel Booking");

        JList<String> bookingList = new JList<>(bookingListModel);
        JScrollPane scrollPane = new JScrollPane(bookingList);

        JPanel top = new JPanel(new GridLayout(4, 2));
        top.add(new JLabel("Room:")); top.add(roomBox);
        top.add(new JLabel("Start (yyyy-MM-ddTHH:mm):")); top.add(startField);
        top.add(new JLabel("End (yyyy-MM-ddTHH:mm):")); top.add(endField);
        top.add(fullTermBox);

        JPanel bottom = new JPanel();
        bottom.add(bookBtn);
        bottom.add(cancelBtn);

        add(top, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        // Booking button
        bookBtn.addActionListener(e -> {
            try {
                Classroom room = (Classroom) roomBox.getSelectedItem();
                LocalDateTime start = LocalDateTime.parse(startField.getText());
                LocalDateTime end = LocalDateTime.parse(endField.getText());

                if (manager.isAvailable(room, start, end)) {
                    Booking b = new Booking(teacher, room, start, end, fullTermBox.isSelected());
                    manager.addBooking(b);
                    bookingListModel.addElement(b.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Room already booked at this time!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input format!");
            }
        });

        // Cancel button
        cancelBtn.addActionListener(e -> {
            int index = bookingList.getSelectedIndex();
            if (index != -1) {
                String selected = bookingListModel.getElementAt(index);
                bookingListModel.remove(index);
                JOptionPane.showMessageDialog(this, "Booking cancelled: " + selected);
            }
        });

        setVisible(true);
    }
}

