package com.kademika.day10.shop.util;

import com.kademika.day10.shop.objectz.Car;
import com.kademika.day10.shop.objectz.Customer;
import com.kademika.day10.shop.objectz.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;

public class GUI {

    private JFrame frame;
    private JPanel buyingPanel = new JPanel();
    private JPanel transanctionPanel = new JPanel();
    private JTextField nameTextField;
    private JFormattedTextField carsCount;
    private ButtonGroup carsGroup;
    private Store store;

    public GUI(final Store store) throws InterruptedException {

        Splash.main(null);

        this.store = store;
        frame = new JFrame("***** CarStore *****");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(150, 150);

        // Add menu to JFrame
        frame.getRootPane().setJMenuBar(getMenuBar());

        // Init buying panel
        buyingPanel.add(getBuyingPanel());

        init();
    }

    private void init() {
        // Init Transactions Table
        transanctionPanel.removeAll();
        transanctionPanel.add(getTransactionsTable());

        frame.getContentPane().removeAll();
        frame.getContentPane().add(transanctionPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private JMenuBar getMenuBar() {

        JMenuItem item = new JMenuItem("Buy a car");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(buyingPanel);
                frame.pack();
            }
        });

        JMenu menu = new JMenu("File");
        menu.add(item);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel getBuyingPanel() {
        // New panel to frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Customer name label
        JLabel nameLabel = new JLabel("Your name: ");
        mainPanel.add(nameLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        // Customer name text field
        nameTextField = new JTextField();
        nameTextField.setColumns(20);
        mainPanel.add(nameTextField, new GridBagConstraints(1, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

        // New cars label
        JLabel carsLabel = new JLabel("Cars:");
        // Add cars label to cars panel
        mainPanel
                .add(carsLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                        GridBagConstraints.LINE_START, 0,
                        new Insets(5, 0, 0, 0), 0, 0));

        // New cars panel
        JPanel carsPanel = new JPanel();
        ArrayList cars = (ArrayList) store.getCarsAvailable();
        carsPanel.setLayout(new GridLayout(cars.size() + 1, 0));
        carsPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // New ButtonGroup
        carsGroup = new ButtonGroup();

        JLabel fieldsLabel = new JLabel("Catalog number - Car for sale - Price");
        fieldsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        carsPanel.add(fieldsLabel);

        // Fill carsPanel with cars
        Iterator it = cars.iterator();
        while (it.hasNext()) {
            Car car = (Car) it.next();
            JRadioButton rb = new JRadioButton(car.getCatNum() + " - "
                    + car.toString() + " - $" + car.getPrice());
            carsGroup.add(rb);
            carsPanel.add(rb);
            if (carsGroup.getButtonCount() == 1) {
                carsGroup.setSelected(rb.getModel(), true);
            }
        }

        // Add cars panel to main panel
        mainPanel
                .add(carsPanel, new GridBagConstraints(1, 1, 1, 1, 0, 0,
                        GridBagConstraints.LINE_START, 0,
                        new Insets(5, 0, 0, 0), 0, 0));

        JLabel countLabel = new JLabel("Count:");
        NumberFormat nf = NumberFormat.getNumberInstance();
        carsCount = new JFormattedTextField(nf);
        carsCount.setColumns(4);
        carsCount.setHorizontalAlignment(JTextField.RIGHT);
        carsCount.setValue(1);

        // Add countLabel to mainPanel
        mainPanel
                .add(countLabel, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                        GridBagConstraints.LINE_START, 0,
                        new Insets(5, 0, 0, 0), 0, 0));

        // Add FormattedTextField to main panel
        mainPanel
                .add(carsCount, new GridBagConstraints(1, 2, 1, 1, 0, 0,
                        GridBagConstraints.LINE_START, 0,
                        new Insets(5, 0, 0, 0), 0, 0));

        JButton checkDiscountButton = new JButton("Check discount");
        mainPanel.add(checkDiscountButton, new GridBagConstraints(1, 3, 2, 1, 0, 0, GridBagConstraints.LINE_START, 0,
                new Insets(0, 0, 0, 0), 0, 0));

        checkDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton jr = null;
                for (Enumeration<AbstractButton> buttons = carsGroup.getElements(); buttons.hasMoreElements(); ) {
                    jr = (JRadioButton) buttons.nextElement();
                    if (jr.isSelected()) {
                        break;
                    }
                }
                String catNum = jr.getText().split(" - ", 0)[0].split("#", 0)[1];
                Car c = store.getCarByCatalogNumber(catNum);
                if (store.hasDiscount(c)) {
                    System.out.println("Discount on " + c + " would be " + store.getDiscountAmount(c));
                } else {
                    System.out.println("No discount on this car!");
                }
            }
        });

        JButton buyButton = new JButton("Buy!");
        mainPanel.add(buyButton, new GridBagConstraints(1, 3, 1, 1, 0, 0,
                GridBagConstraints.LINE_END, 0, new Insets(0, 0, 0, 0), 0, 0));

        buyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameTextField.getText().isEmpty()) {
                    System.err.println("Enter customer name!");
                } else {
                    JRadioButton jr = null;
                    for (Enumeration<AbstractButton> buttons = carsGroup
                            .getElements(); buttons.hasMoreElements(); ) {
                        jr = (JRadioButton) buttons.nextElement();
                        if (jr.isSelected()) {
                            break;
                        }
                    }
                    String catNum = jr.getText().split(" - ", 0)[0].split("#",
                            0)[1];

                    Customer c = new Customer();
                    c.setFullName(nameTextField.getText());

                    store.sellCar(catNum, Integer.parseInt(carsCount.getText()), c);

                    init();
                }
            }
        }

        );


        return mainPanel;
    }

    private JScrollPane getTransactionsTable() {

        JTable table = new JTable(Staticz.getTransactionsTable(store),
                Staticz.getTransactionFields());
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);

        JScrollPane pane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));
        table.setFillsViewportHeight(true);

        return pane;
    }
}
