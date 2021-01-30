import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.text.DecimalFormat;


public class Spiel {

    JFrame spielfenster;
    Container con;
    JPanel titlePanel, startbtnPanel, mainTextPanel, choiceButtonPanel, spielerPanel;
    JLabel title, extrasLabel, geldLabel, zeitLabel, notenschnittLabel;
    Font textgr = new Font("Arial", Font.PLAIN, 44);
    Font normaletextgr = new Font("Arial", Font.PLAIN, 34);
    Font btntextgr = new Font("Arial", Font.PLAIN, 18);
    JButton startbtn, choice1, choice2, choice3, choice4, choice5;
    JTextArea questionTextArea;
    
    static int geld, id, second, min;
    double notenschnitt;
    String sec, m;
	Timer timer;
	DecimalFormat f = new DecimalFormat("00");
    
    
    ScreenHandler tsHandler = new ScreenHandler();
    ChoiseHandler choiseHandler = new ChoiseHandler();
    
    public static void main(String[] args) {
    
       new Spiel();
    }
    public Spiel(){
        //StartScreen
        
        
        //Fenster erstellen
        spielfenster = new JFrame();
        spielfenster.setSize(1200, 1000);
        spielfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spielfenster.getContentPane().setBackground(Color.black);
        spielfenster.setLayout(null);
        spielfenster.setVisible(true);
        con = spielfenster.getContentPane();
        
        // Titelfeld erstellen
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 1000, 800);
        titlePanel.setBackground(Color.black);
        
        // Titellabel
        title = new JLabel("Willkommen bei Der Aufstieg als Informatiker");
        title.setForeground(Color.green);
        title.setFont(textgr);
        
        //StartButtonfeld erstellen
        startbtnPanel = new JPanel();
        startbtnPanel.setBounds(500, 600, 200, 100);
        startbtnPanel.setBackground(Color.black);
        //StartButton erstellen
        startbtn = new JButton("START");
        startbtn.setBackground(Color.black);
        startbtn.setForeground(Color.green);
        startbtn.setFont(normaletextgr);
        startbtn.addActionListener(tsHandler);
        startbtn.setFocusPainted(false);
        
        //Label zum Feld hinzufügen 
        titlePanel.add(title);
        startbtnPanel.add(startbtn);
        
        
        con.add(titlePanel);
        con.add(startbtnPanel);
        
        
    }
    public void spielScreen(){
        titlePanel.setVisible(false);
        startbtnPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(150, 200, 900, 300);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        // Fragenfeld erstellen
        questionTextArea = new JTextArea();
        questionTextArea.setBounds(100, 100, 850, 500);
        questionTextArea.setBackground(Color.black);
        questionTextArea.setForeground(Color.green);
        questionTextArea.setFont(normaletextgr);
        questionTextArea.setLineWrap(true);
        questionTextArea.setEnabled(false);
        mainTextPanel.add(questionTextArea);
        
        //Antwortenfeld erstellen
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(370, 520, 450, 200);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5, 1));
        con.add(choiceButtonPanel);
        
        //AntwortButtons erstellen
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.green);
        choice1.setFont(btntextgr);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiseHandler);
        choice1.setActionCommand("a1");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.green);
        choice2.setFont(btntextgr);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiseHandler);
        choice2.setActionCommand("a2");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.green);
        choice3.setFont(btntextgr);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiseHandler);
        choice3.setActionCommand("a3");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.green);
        choice4.setFont(btntextgr);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiseHandler);
        choice4.setActionCommand("a4");
        choiceButtonPanel.add(choice4);
		
		choice5 = new JButton("Choice 5");
        choice5.setBackground(Color.black);
        choice5.setForeground(Color.green);
        choice5.setFont(btntextgr);
        choice5.setFocusPainted(false);
        choice5.addActionListener(choiseHandler);
        choice5.setActionCommand("a5");
        choiceButtonPanel.add(choice5);
        
        //Spielerfeld erstellen
        spielerPanel = new JPanel();
        spielerPanel.setBounds(300, 800, 600, 50);
        spielerPanel.setBackground(Color.black);
        spielerPanel.setLayout(new GridLayout(1, 4));
        con.add(spielerPanel);
        
        //Extras Labels erstellen
        extrasLabel = new JLabel("Extras: ");
        extrasLabel.setFont(btntextgr);
        extrasLabel.setForeground(Color.green);
        spielerPanel.add(extrasLabel);
        
        geldLabel = new JLabel("Extras: ");
        geldLabel.setFont(btntextgr);
        geldLabel.setForeground(Color.green);
        spielerPanel.add(geldLabel);
        
        zeitLabel = new JLabel("Extras: ");
        zeitLabel.setFont(btntextgr);
        zeitLabel.setForeground(Color.green);
        spielerPanel.add(zeitLabel);        
        
        notenschnittLabel = new JLabel("Extras: ");
        notenschnittLabel.setFont(btntextgr);
        notenschnittLabel.setForeground(Color.green);
        spielerPanel.add(notenschnittLabel); 
        
        
        spielerSetup();
        
        
    }
    
    
    public void spielerSetup(){
        geld = 250;
        notenschnitt = 2.5;
        geldLabel.setText("Geld: " + geld);
        notenschnittLabel.setText("Notenschnitt: " + notenschnitt);
        
        frage1();
		zeitLabel.setText("Zeit:  " + "00" + " : " + "00");
		second =0;
		min = 0;
		Timer();
		timer.start();
        
    }
    public void frage1(){
        id = 1;
        choice2.setVisible(true);
        questionTextArea.setText("Wie viele Stunden investierst du pro Woche für Mathe?");
        choice1.setText("Weniger als 5 Std.");
        choice2.setText("Mehr als 5 Std.");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void cho1(){
        id = 2;
        questionTextArea.setText("Mathe läuft schlecht!");
        choice1.setText(">");
        choice2.setVisible(false);
		choice5.setVisible(false);
        


    }
    public void cho2(){
        id = 3;
        questionTextArea.setText("Mathe läuft sehr gut ");
        choice1.setText(">");
        choice2.setVisible(false);
		choice5.setVisible(false);
        


    }

    public void frage2(){
        id = 4;
        choice2.setVisible(true);
        questionTextArea.setText("Suchst du bereits eine Lerngruppe?");
        choice1.setText("Ja, ich suche eine Lerngruppe");
        choice2.setText("Nein, ich suche mir keine Lerngruppe");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);

        
        
    }
    
    public void frage3(){
        id = 5;
        questionTextArea.setText("Willst du deine Entscheidung überdenken");
        choice1.setText("Ja, ich werde mir doch eine Lerngruppe suchen");
        choice2.setVisible(true);
        choice2.setText("Nein, ich schaffe das ohne Lerngruppe");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage4(){
        id = 6;
        questionTextArea.setText("Nun zum nächsten Modul. Hast du bereits Vorkenntnisse in Java?");
        choice1.setText("Ja, ich habe bereits Vorkenntnisse in Java");
        choice2.setVisible(true);
        choice2.setText("Nein, ich habe noch nichts mit Java zu tun gehabt");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    

    public void frage5(){
        id = 7;
        questionTextArea.setText("Was ist die Ausgabe?"
                + "\\n\\nint i = 2;\\nint total = 0;\\nwhile\"\n (i < 9) {\\n  i++\\n  total = total + i;\\n}\\nSystem.out.println(total);\\n");
        choice1.setText("42");
        choice2.setVisible(true);
        choice2.setText("39");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }

    public void frage6(){
        id = 8;
        questionTextArea.setText("Bist du von zu Hause ausgezogen ");
        choice1.setText("Ja");
        choice2.setVisible(true);
        choice2.setText("Nein");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }

    public void frage7(){
        id = 9;
        questionTextArea.setText("Wohnst du  in einer WG oder alleine? ");
        choice1.setText("Ich wohne in einer WG");
        choice2.setVisible(true);
        choice2.setText("Ich wohne alleine");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
 
    public void frage8(){
        id = 10;
        questionTextArea.setText("Du hast die Möglichkeit einen Nebenjob zu machen um deine \nHaushaltskasse etwas aufzubessern ");
        choice1.setText("Das hört sich vernünftig an, dann bin ich \n maximal selbstständig");
        choice2.setVisible(true);
        choice2.setText("Ach, das passt schon ich hab andere Quellen die mich unterstützen, da\"\nmuss ich selbst nicht arbeiten gehen");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage9(){
        id = 11;
        questionTextArea.setText("Falls du Vorkenntnisse in Programmierung hast, kannst du dich\"\njetzt nach einem Nebenjob in diesem Bereich umsehen ");
        choice1.setText("Da kann ich auch gleich noch Praxiserfahrung sammeln, das klingt gut");
        choice2.setVisible(true);
        choice2.setText("Ich suche mir lieber einen \\\"normalen\\\" Nebenjob und gehe kellnern");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage10(){
        id = 12;
        questionTextArea.setText("Aus welchen Quellen kommt denn das Geld? ");
        choice1.setText("Meine Eltern");
        choice2.setVisible(true);
        choice2.setText("Bafög");
        choice3.setVisible(true);
        choice3.setText("Ich hab meine Eltern und Bafög");
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage11(){
        id = 13;
        questionTextArea.setText("In der Uni steht die erste Prüfung kurz vor der Tür,\ngleichzeitig hat aber auch dein bester Freund seinen 18. Geburtstag. Was machst du? ");
        choice1.setText("Gar keine Frage, man wird nur einmal 18. Das kann ich nicht\n verpassen!");
        choice2.setVisible(true);
        choice2.setText("Das Studium hat auf jeden Fall Priorität, sonst wäre ja das ganze\"\nSemester umsonst gewesen!");
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage12(){
        id = 14;
        questionTextArea.setText("Du warst feiern und wachst am Morgen der Prüfung in einem Regio\nin Erfurt auf und wunderst dich wie du es soweit geschafft hast ");
        choice1.setText("Was soll man machen. Immer nach vorne schauen\"");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage13(){
        id = 15;
        questionTextArea.setText("Du hast aufgrund deiner ungeplanten Reise nicht mehr rechtzeitig \nzur Prüfung geschafft und musst sie wiederholen! ");
        choice1.setText("Dann mach ich das dieses mal aber richtig");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage14(){
        id = 16;
        questionTextArea.setText("Du hast die Prüfung geschrieben und bestanden herzlichen\nGlückwunsch.\\n Auf gehts ins nächste Semester ");
        choice1.setText("Und los!");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
		choice5.setVisible(false);
        
        
    }
    public void frage15(){
        id = 17;
        questionTextArea.setText("Herzlich Willkommen im 3.Semester!");
        choice1.setText("Auf zur Wahl deiner Spezialisierung!");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false); 
        choice5.setVisible(false);
		choice5.setVisible(false);
        
    }
    
    public void frage16(){
        id = 18;
        questionTextArea.setText("Wähle eine der Spezialisierungen.");
        choice1.setText("Embedded Systems");
        choice2.setVisible(true);
        choice2.setText("Internet Engineering");
        choice3.setVisible(true);
        choice3.setText("Medieninformatik");
        choice4.setVisible(true);  
        choice4.setText("Wirtschaftsinformatik");
        choice5.setVisible(true);
        choice5.setText("keine Spezialisierung");
        
    }  
    public void frage17(){
        id = 19;
        questionTextArea.setText("Besuchst du regelmäßig die Veranstalltungen (Vorlesungen, etc.)");
        choice1.setText("Ja");
        choice2.setVisible(true);
        choice2.setText("Nein");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage18(){
        id = 20;
        questionTextArea.setText("Wie findest du das Studium bis zu diesem Punkt?");
        choice1.setText("Gut!");
        choice2.setVisible(true);
        choice2.setText("Anstrengend, wird aber schon!");
        choice3.setVisible(true);
        choice3.setText("Schlecht");
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage19(){
        id = 21;
        questionTextArea.setText("Ändere deine Spezialisierung oder wechsel den Studiengang?");
        choice1.setText("Spezialisierung ändern!");
        choice2.setVisible(true);
        choice2.setText("Studiengang wechseln!");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage20(){
        id = 22;
        questionTextArea.setText("Du wechseltst den Studiengang! Dieser Weg endet hier!");
        choice1.setText("Spiel beenden!");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void wiederholungsfrage16(){
        id = 1000;
        questionTextArea.setText("Wähle eine der Spezialisierungen.");
        choice1.setText("Embedded Systems");
        choice2.setVisible(true);
        choice2.setText("Internet Engineering");
        choice3.setVisible(true);
        choice3.setText("Medieninformatik");
        choice4.setVisible(true);  
        choice4.setText("Wirtschaftsinformatik");
        choice5.setVisible(true);
        choice5.setText("keine Spezialisierung");
        
    } 
    
    public void frage21(){
        id = 23;
        questionTextArea.setText("Du hast die nächsten Semester soweit gemeistert! \nSemesterferien stehen an! Ab ins Privatleben!");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    
    public void frage22(){
        id = 24;
        questionTextArea.setText("Willst du mit deinen Kumpels nach Mallorca?");
        choice1.setText("Na Klar!");
        choice2.setVisible(true);
        choice2.setText("Nein ich muss mich auf mein Studium konzentrieren.");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage23(){
        id = 25;
        questionTextArea.setText("Nach ein paar Tagen feiern wird ein Freund festgenommen und\nihr teilt euch die Kosten!");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage24(){
        id = 26;
        questionTextArea.setText("Nach erfolgreichem Lernen gehst du in eine Kneipe/Kirmes/Club und lernst"
                + "\njemanden kennen.\nHast du Interesse an einer Beziehung ");
        choice1.setText("Ja");
        choice2.setVisible(true);
        choice2.setText("Nein");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage25(){
        id = 27;
        questionTextArea.setText("Studium-Anstrengend?");
        choice1.setText("Ja");
        choice2.setVisible(true);
        choice2.setText("Nein");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage26(){
        id = 28;
        questionTextArea.setText("Ihr hattet ein paar Dates.\nDu bist nun in einer festen Beziehung");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage27(){
        id = 29;
        questionTextArea.setText("Dein Partner fragt, ob ihr zusammenziehen wollt.");
        choice1.setText("Ja");
        choice2.setVisible(true);
        choice2.setText("Nein");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage28(){
        id = 30;
        questionTextArea.setText("Du bekommst ein Jobangebot von <Spezialisierung>!");
        choice1.setText("Jobangebot annehmen!");
        choice2.setVisible(true);
        choice2.setText("Jobangebot ablehnen!");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage29(){
        id = 31;
        questionTextArea.setText("Du begibst dich ins Berufsleben!");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage30(){
        id = 32;
        questionTextArea.setText("Du machst das Studium fertig, aber verlierst das Jobangebot!");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage31(){
        id = 33;
        questionTextArea.setText("Hast du dchon ein Thema für dein Bachelor Arbeit?");
        choice1.setText("Ja");
        choice2.setVisible(true);
        choice2.setText("Nein");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage32(){
        id = 34;
        questionTextArea.setText("Deine Freunde laden dich zu einem spontanen Studie-Trip ein.\nGehst du mit? ");
        choice1.setText("Ja, ich habe ja noch Zeit");
        choice2.setVisible(true);
        choice2.setText("Nein, ich muss mich auf andere Sachen konzentrieren");
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage33(){
        id = 35;
        questionTextArea.setText("Du hast dich verschätzt und hast nicht geschafft dich gut vorzubreiten.");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage34(){
        id = 36;
        questionTextArea.setText("Du bist ein sehr vorbildlicher Student, die Zeichen stehen gut");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage35(){
        id = 37;
        questionTextArea.setText("Du hast eine durchschnittliche Bachelorarbeit geschrieben, du\nhast das Studium soweit abgeschlossen");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void frage36(){
        id = 38;
        questionTextArea.setText("Du hast eine sehr gute Bachelorarbeit geschrieben, Du hast dein\nBachelor-Studium abgeschlossen");
        choice1.setText("Weiter");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);        
        choice5.setVisible(false);
    }
    public void ende(){
        id = 39;
        questionTextArea.setText("Hier endet dein Aufstieg als Informatiker. Vielen dank für das Spielen. ");
        choice1.setText("Spiel beenden");
    }
    
    public class ScreenHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            spielScreen();
        }
        
    }
    
    public class ChoiseHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            
            switch (id){
                case 1:
                    switch (yourChoice){
                        case "a1": cho1(); break;
                        case "a2": cho2(); break;
 
                    }
                break;
                case 2:
                    switch(yourChoice){
                        case "a1": frage2(); break;
                    }
                break;
                case 3:
                    switch(yourChoice){
                        case "a1": frage2(); break;
                    }
                break;
                    
                case 4:
                    switch (yourChoice){
                        case "a1": frage4(); break;
                        case "a2": frage3(); break;
 
                    }
                break;

                case 5:
                    switch(yourChoice){
                        case "a1": frage4(); break;
                        case "a2": JOptionPane.showMessageDialog(null, "TIPP: Eine Lerngruppe hilft den Stoff nocheinmal zu wiederholen\" \nund in der Gruppe zu besprechen\"");
                        frage4(); break;
                    }
                break;
                case 6 :
                    switch (yourChoice){
                        case "a1": frage5(); break;
                        case "a2": frage5(); break;
                        
                    }
                break;
                case 7 :
                    switch (yourChoice){
                        case "a1": JOptionPane.showMessageDialog(null, "Du hast es geschafft und die Prüfung bestanden.\nUnd jetzt\ngeht's weg von der Uni ab nach Hause ins Privatleben");
                        frage6(); break;
                        case "a2": JOptionPane.showMessageDialog(null, "Du musst viel Zeit investieren um in Prog1 am Ball zu bleiben. Du\nhast weniger Zeit für andere Dinge");
                        frage6(); break;
                        
                    }
                break;
                case 8 :
                    switch (yourChoice){
                        case "a1": 
                            frage7(); break;
                        case "a2": JOptionPane.showMessageDialog(null, "Da du zu Hause wohnst hast du weniger Ausgaben, aber deine\nGeschwister lassen dich einfach nicht in Ruhe lernen!");
                            frage8(); break;
                    }
                break;
                case 9 :
                    switch (yourChoice){
                        case "a1": JOptionPane.showMessageDialog(null, "Du hast coole Mitbewohner, aber auch deine Ruhe, wenn du lernen\nmusst. Allerdigns sind deine Ausgaben höher");
                            frage8(); break;
                        case "a2": JOptionPane.showMessageDialog(null, "Du wohnst alleine und kannst machen was du willst, in Ruhe\nlernen, feiern gehen, worauf du Lust hast! Allerdings ist die Wohnung nicht ganz günstig!");
                            frage8(); break;
                    }
                break;
                case 10 :
                    switch (yourChoice){
                        case "a1": frage9(); break;
                        case "a2": frage10(); break;
                        
                    }
                break;
                case 11 :
                    switch (yourChoice){
                        case "a1": frage11(); break;
                        case "a2": frage11(); break;
                    }
                break;
                case 12 :
                    switch (yourChoice){
                        case "a1": frage11(); break;
                        case "a2": frage11(); break;
                        case "a3": frage11(); break;
                    }
                break;
                case 13 :
                    switch (yourChoice){
                        case "a1": frage12(); break;
                        case "a2": frage14(); break;
                    }
                break;
                case 14 :
                    switch (yourChoice){
                        case "a1": frage13(); break;
                    }
                break;
                case 15 :
                    switch (yourChoice){
                        case "a1": frage14(); break;
                    }
                break;
                case 16:
                    switch (yourChoice){
                        case "a1": frage15(); break;
                    }
                break;
                case 17:
                    switch (yourChoice){
                        case "a1": frage16(); break;
                    }
                break;
                case 18:
                    switch (yourChoice){
                        case "a1": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage17(); break;
                        case "a2": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage17(); break;
                        case "a3": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage17(); break;
                        case "a4": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage17(); break;
                        case "a5": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Wahl.");frage17(); break;
                    }
                break;
                case 19:
                    switch (yourChoice){
                        case "a1": frage18(); break;
                        case "a2": frage18(); break;
                    }
                break;
                case 20:
                    switch (yourChoice){
                        case "a1": frage21(); break;
                        case "a2": frage21(); break;
                        case "a3": frage19(); break;
                    }
                break;
                case 21 :
                    switch (yourChoice){
                        case "a1": wiederholungsfrage16();break;
                        case "a2": frage20(); break;
                    }
                break;
                case 1000:
                    switch(yourChoice){
                        case "a1": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage21(); break;
                        case "a2": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage21(); break;
                        case "a3": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage21(); break;
                        case "a4": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Spezialisierung.");frage21(); break;
                        case "a5": JOptionPane.showMessageDialog(null,"Du belegst 3 Fächer deiner Wahl.");frage21(); break;
                    }
                break;
                case 22:
                    switch(yourChoice){
                        case "a1": timer.stop();
                            JFrame exit = new JFrame("EXIT");
                            if(JOptionPane.showConfirmDialog(exit, "Spiel beenden", "Exit", JOptionPane.YES_NO_OPTION)
                                    ==JOptionPane.YES_NO_OPTION){
                                System.exit(0);
                            } // https://www.youtube.com/watch?v=DmtGxIdXtsI                         
                    }
                break;
                case 23:
                    switch(yourChoice){
                        case "a1": frage22(); break;
                    }
                break;
                case 24:
                    switch(yourChoice){
                        case "a1": frage23(); break;
                        case "a2": frage24(); break;
                    }
                break;
                case 25:
                    switch(yourChoice){
                        case "a1": frage28(); break;
                    }
                break;
                case 26:
                    switch(yourChoice){
                        case "a1": frage25(); break;
                        case "a2": frage28(); break;
                    }
                break;
                case 27:
                    switch(yourChoice){
                        case "a1": JOptionPane.showMessageDialog(null,"Du musst deinen Partner mehrfach, wegen des Studiums versetzen!\nAus der Beziehung wird leider nichts!");frage28(); break;
                        case "a2": frage26(); break;
                    }
                break;
                case 28:
                    switch(yourChoice){
                        case "a1": frage27(); break;  
                    }
                break;
                case 29:
                    switch(yourChoice){
                        case "a1": frage28(); break;
                        case "a2": frage28(); break;                            
                    }
                break;
                case 30:
                    switch(yourChoice){
                        case "a1": frage29(); break;
                        case "a2": frage30(); break;    
                    }
                case 31:
                    switch(yourChoice){
                        case "a1": ende(); break;
                    }
                break;
                case 32:
                    switch(yourChoice){
                        case "a1": frage31(); break;
                    }
                break;
                case 33:
                    switch(yourChoice){
                        case "a1": frage32(); break;
                        case "a2": frage32(); break;                      
                    }
                break;
                case 34:
                    switch(yourChoice){
                        case "a1": frage34(); break;
                        case "a2": frage33(); break;
                    }
                break;
                case 35:
                    switch(yourChoice){
                        case "a1": frage35(); timer.stop(); break;
                    }
                break;
                case 36:
                    switch(yourChoice){
                        case "a1": frage36(); timer.stop();break;
                    }
                break;
                case 37:
                    switch(yourChoice){
                        case "a1": ende();break;
                    }
                break;
                case 38:
                    switch(yourChoice){
                        case "a1": ende();break;
                    }
                break;
                case 39:
                    switch(yourChoice){
                        case "a1": timer.stop();
                            JFrame exit = new JFrame("EXIT");
                            if(JOptionPane.showConfirmDialog(exit, "Spiel beenden", "Exit", JOptionPane.YES_NO_OPTION)
                                    ==JOptionPane.YES_NO_OPTION){
                                System.exit(0);
                            }
                    }

            }
   
        }
        
    }
    public void Timer(){
        timer = new Timer(1000, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				sec = f.format(second);
				m = f.format(min);
				zeitLabel.setText("Zeit:  "+ m + " : "+ sec);
				if(second ==60){
					second =0;
					min++;
					zeitLabel.setText("Zeit:  " + m + " : " + sec);
						
				}

			}



        });
        //Quelle Timer : https://www.youtube.com/watch?v=zWw72j-EbqI
    }	
    
}