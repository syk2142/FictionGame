import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel,hpLabel, hpLabelNumber, toolLabel,toolLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int PlayerHP;
    String tool, position;


    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setSize(1200, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("The Five People You Meet In Heaven");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

    }

    public void creatGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(hpLabelNumber);

        toolLabel = new JLabel("Tool: ");
        toolLabel.setFont(normalFont);
        toolLabel.setForeground(Color.WHITE);
        playerPanel.add(toolLabel);

        toolLabelName = new JLabel();
        toolLabelName.setFont(normalFont);
        toolLabelName.setForeground(Color.WHITE);
        playerPanel.add(toolLabelName);

        playerSetup();

    }
    public void playerSetup(){
        PlayerHP = 15;
        tool = "Hammer";
        toolLabelName.setText(tool);
        hpLabelNumber.setText(""+PlayerHP);

        rubyPier();
    }
    public void rubyPier(){
        position = "rubyPier";
        mainTextArea.setText("You are at the Ruby Pier, an amusement park \nby a great gray ocean. You are the ride man. \nAn emergency occurred.\nYou need to go fix the Freddy's Free Fall,\nhowever, you noticed a little girl right beneath the ride. \n\n What do you do?");
        choice1.setText("Talk to Dominguez");
        choice2.setText("Fix the Free Fall");
        choice3.setText("Save the girl");
        choice4.setText("");
    }
    public void talkDominguez(){
        position = "talkDominguez";
        mainTextArea.setText("Oh my God! Those people gonna fall! \nDo something!");
        choice1.setText("Fix the Free Fall");
        choice2.setText("Save the girl");
        choice3.setText("");
        choice4.setText("");
    }
    public void fixFreeFall(){
        position = "fixFreeFall";
        mainTextArea.setText("Engine. Cylinders. Hydraulics. Seals. Cables. \nHow does a cart come loose?\nYou got hurt while fixing the ride.\nThe cart start falling. ");
        hpLabelNumber.setText(""+PlayerHP);
        choice1.setText("Save the girl");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void saveGirl(){
        position = "saveGirl";
        mainTextArea.setText("Whump. Too late. The carts were dropping. \nYou half flew, half stumbled toward her,\nYou felt two hands, two small hands.\nA stunning impact, then nothing.   \nYou are dead ");
        PlayerHP = PlayerHP -15;
        hpLabelNumber.setText(""+PlayerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("You awake at a cross road. \nSee a sign that says \nBlueman, Captain, Ruby, and ...");
        hpLabelNumber.setText(""+PlayerHP);
        choice1.setText("Blueman");
        choice2.setText("Captain");
        choice3.setText("Ruby");
        choice4.setText("");

    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            creatGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event ){
            String yourChoice = event.getActionCommand();
            switch(position){
                case "rubyPier":
                    switch(yourChoice){
                        case"c1": talkDominguez();break;
                        case"c2": fixFreeFall();break;
                        case"c3": saveGirl();break;
                        case"c4": break;
                    }
                    break;
                case"talkDominguez":
                    switch(yourChoice){
                        case"c1": fixFreeFall();break;
                        case"c2": saveGirl();break;
                    }
                    break;
                case "fixFreeFall":
                    switch(yourChoice){
                        case"c1":saveGirl();break;
                    }
                    break;
                case "saveGirl":
                    switch(yourChoice){
                        case"c1":crossRoad();break;
                    }
                    break;
                case "crossRoad":
                    switch(yourChoice){
                        case"c1":break;
                        case"c2":break;
                        case"c3":break;
                        case"c4":break;
                    }

            }

        }
    }
}

