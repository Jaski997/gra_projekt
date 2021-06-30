import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");



    public static void main(String[] args) {

        new Game();
    }

    public Game(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("GOTHIC TYLKO ZE DOBRY");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("elegancka gierka");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Sprzęt:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setBackground(Color.red);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }
    public void playerSetup(){

        playerHP = 15;
        monsterHP = 20;
        weapon = "Nóz";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("Stoisz na bramie do miasta. \nStraznik stoi przed toba. \n\nco robisz??");
        choice1.setText("Bajera ze straznikiem");
        choice2.setText("Zaatakuj straznika");
        choice3.setText("Oddal sie");
        choice4.setText("");
    }
    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Straznik: Witamy w Radomiu, nie kojarze cie z gęby \nSorki nie wpuszcze nieznajomego do miasta.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Straznik: Nie wydurniaj sie kmiocie!\n\nStraznik sprzedal ci gonga.\n(otrzymales 3 pkt. obrazen)");
        //playerHP = playerHP -3;
        playerHP -=3;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("jestes na rozdrozu.\nIdac na poludnie wrocisz do miasta");
        choice1.setText("Idz na Polnoc");
        choice2.setText("Idz na Wschod");
        choice3.setText("Idz na Poludnie");
        choice4.setText("Idz na zachod");
    }
    public void north(){
        position = "north";
        mainTextArea.setText("Dotarles do rzeki. \nNapoiles sie i odpoczales nad brzegiem. \n\n(Przywrocilo ci to 2 HP)");
        playerHP = playerHP + 2;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText("Idz na Poludnie");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void east(){
        position = "east";
        mainTextArea.setText("Przedarles sie przez krzaki i znalazles okazala bron biala...\n\n(Otrzymales miecz dwureczny!)");
        weapon = "Miecz Dwureczny";
        weaponLabelName.setText(weapon);
        choice1.setText("Idz na zachod");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void west(){
        position = "west";
        mainTextArea.setText("Napotkales Wojtyle!!");
        choice1.setText("Walcz");
        choice2.setText("Ucieknij");
        choice3.setText("");
        choice4.setText("");
    }
    public void fight(){
        position = "fight";
        mainTextArea.setText("HP Potwora: " + monsterHP + "\n\nCo dalej?");
        choice1.setText("Walcz");
        choice2.setText("Ucieknij");
        choice3.setText("");
        choice4.setText("");
    }
    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if(weapon.equals("Knife")){
            playerDamage = new java.util.Random().nextInt(3);
        }
        else if(weapon.equals("Long Sword")){
            playerDamage = new java.util.Random().nextInt(12);
        }

        mainTextArea.setText("Zaatakowales Przeciwnika i zadales " + playerDamage + " obrazen!");

        monsterHP = monsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("Przeciwnik zaatakowal cie zadajac " + monsterDamage + " obrazen!");

        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText(""+playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void win(){
        position = "win";

        mainTextArea.setText("Pokonales przeciwnika!\nOdcinajac mu palec spadl z niego pierscien!\n\n(Otrzymales Papieski Pierscien)");

        silverRing = 1;

        choice1.setText("Idz na zachód");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void lose(){
        position = "lose";

        mainTextArea.setText("Nie żyjesz!\n\nGAME OVER");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void ending(){
        position = "ending";

        mainTextArea.setText("Straznik: Poskladales Goblina?\nLegancko, kozak z ciebie!\nZapraszam do miasta!\n\nKONIEC XD \n\n (Ciekawostka, gobliny stanowia 13% spoleczenstwa, ale dpowiadaja za 52% przestepstw)");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }




    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }


    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position){
                case "townGate":
                    switch(yourChoice){
                        case "c1":
                            if(silverRing==1){
                                ending();
                            }
                            else{
                                talkGuard();
                            }
                            break;
                        case "c2": attackGuard();break;
                        case "c3": crossRoad();break;
                    }
                    break;
                case "talkGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "crossRoad":
                    switch(yourChoice){
                        case "c1": north(); break;
                        case "c2": east();break;
                        case "c3": townGate(); break;
                        case "c4": west();break;
                    }
                    break;
                case "north":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
                case "east":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
                case "west":
                    switch(yourChoice){
                        case "c1": fight(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "fight":
                    switch(yourChoice){
                        case "c1": playerAttack();break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "playerAttack":
                    switch(yourChoice){
                        case "c1":
                            if(monsterHP <1 ){
                                win();
                            }
                            else{
                                monsterAttack();
                            }
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch(yourChoice){
                        case "c1":
                            if(playerHP <1 ){
                                lose();
                            }
                            else{
                                fight();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch(yourChoice){
                        case "c1": crossRoad();
                    }
                    break;

            }


        }
    }

}