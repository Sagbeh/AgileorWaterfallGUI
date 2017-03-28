package com.Sam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by samagbeh on 3/27/17.
 */
public class AgilevsWaterfall extends JFrame{
    private JTextField projectName;
    private JCheckBox thereAreMoreThanCheckBox;
    private JCheckBox thereAreNeedsForCheckBox;
    private JCheckBox thereAreStringentQualityCheckBox;
    private JCheckBox theProgrammersHaveExperienceCheckBox;
    private JCheckBox earlyIntegrationIsDesirableCheckBox;
    private JCheckBox theCustomerWillBeCheckBox;
    private JButton recommendButton;
    private JButton quitButton;
    private JPanel rootPanel;
    private JLabel reccommendation;

    private boolean programmers, deadlines, exp, quality, integration, customer;
    private int programmersInt, deadlinesInt, expInt, qualityInt, integrationInt, customerInt;


    AgilevsWaterfall() {
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        thereAreMoreThanCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                programmers = thereAreMoreThanCheckBox.isSelected();


            }
        });
        thereAreNeedsForCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                deadlines = thereAreNeedsForCheckBox.isSelected();

            }
        });
        theProgrammersHaveExperienceCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                exp = theProgrammersHaveExperienceCheckBox.isSelected();

            }
        });
        thereAreStringentQualityCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                quality = thereAreStringentQualityCheckBox.isSelected();

            }
        });
        earlyIntegrationIsDesirableCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                integration = earlyIntegrationIsDesirableCheckBox.isSelected();

            }
        });
        theCustomerWillBeCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                customer = theCustomerWillBeCheckBox.isSelected();

            }
        });
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String myProjectName = projectName.getText();

                int result = recommender(programmers, deadlines, exp, quality, integration, customer);

                if (result > 2) {
                    reccommendation.setText( myProjectName + " should use the waterfall method.");
                } else {
                    reccommendation.setText( myProjectName + " should use the agile method.");
                }
            }


        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }

        public int recommender(boolean programmers, boolean deadlines, boolean exp, boolean quality, boolean integration, boolean customer) { // creates a method that returns
            // evaluation as an integer 1-5
            int decision = 0;

            programmersInt = programmers ? 1 : 0;
            deadlinesInt = deadlines ? 1 : 0;
            expInt = exp ? 0 : 1;
            qualityInt = quality ? 1 : 0;
            integrationInt = integration ? 0 : 1;
            customerInt = customer ? 0 : 1;

            decision = programmersInt + deadlinesInt + expInt + qualityInt + integrationInt + customerInt;

            return decision;

        }


    }
