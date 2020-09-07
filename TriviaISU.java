import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TriviaISU {
	
	static Font font2=new Font("Berlin Sans FB Demi",Font.PLAIN,0);
	static EmptyBorder border1 = new EmptyBorder(0, 0, 0, 0);
	static Random rand=new Random();
	
	static int correctAnswer = 0,wrongAnswers;
	
	//Multi-Dimensional Array, 1st is the question, next is the choices for the answers and the last is what position is the answer
	static String[][] Questions = { 
		                        {"In which year was the lego company founded?","1930", "1931", "1932","1933", "3"},
		                        {"Which country gave us the words 'shampoo' and 'pyjamas'?", "India", "China", "Spain", "Japan", "1"},
		                        {"What percentage of our body weight is water?", "70%", "60", "80%", "50%", "2"},
		                        {"Which U.S. President is Donald Trump?", "30th", "40th", "45th", "50th", "3"}, 
		                        {"What jersey number does LeBron James wear?", "24", "6", "35", "23", "4"},
		                        {"Who are the developers of the game?", "Zain & Riishi", "Sanje & Zain", "Riishi & Ammar", "Sanje & Ammar", "2"},
		                        {"What is the highest number found on a standard roulette wheel?", "50", "100", "36", "20", "3"},
		                        {"Which water sport is the official state sport of Hawaii?", "Surfing", "Swimming", "Diving", "Water Polo", "1"},
		                        {"In what country were the Winter Olympics first held?", "Russia", "Greece", "Canada", "France", "4"},
		                        {"What was the first public U.S. company to reach $1 trillion market?", "Microsoft", "Apple", "Google", "Amazon", "2"},
		                        {"Jim Davis was the cartoonist behind which widely known comic?", "Peanuts", "Garfield", "Calvin & Hobbes", "Big Nate", "2"},
		                        {"What city is most commonly referred to as “The City of Light”?", "Athens, Greece", "Paris, France", "Las Vegas, USA", "Venice, Italy", "2"},
		                        {"How many teams are in the American National Football league?", "32", "30", "20", "29", "1"},
		                        {"Which continent is also a country?", "Antarctica", "Africa", "Australia", "America", "3",},
		                        {"What is called when a player scores 2 goals in a game of soccer?", "Hatrick", "Double Shot", "Goal", "Brace", "4"},
		                        {"A fortnight is a unit of time equal to how many days?", "10 Days", "20 Days", "14 Days", "100 Days", "3"},
		                        {"What is the most popular fast food item?", "Hotdog", "Pizza", "Fries", "Burger", "4"},
		                        {"What year did Dragon Ball Z first air?", "1996", "1989", "1981", "1984", "2"},
		                        {"What was Walt Disney’s middle name?", "Elias", "Dexter", "Magic", "Arnold", "1"},
		                        {"What do golfers shout to warn other golfers when they hit a shot?", "Incoming!", "Watch Out!", "Heads!", "Fore!", "4"},
								};
						
	
	//set at -1 because the game won't think duplicates were created if they randomly select 0
	static int[] questionnums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	
	public static void main(String args[]) {
		
		RandomQuestions();
		
        //Creating the Main
        JFrame TriviaMain = new JFrame("Trivia");
        TriviaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set Frame size
        TriviaMain.setSize(1000, 730);

        //Creating the panel 
        JPanel TriviaPanel = new JPanel(); 
        //Set panel layout
        TriviaPanel.setLayout(new BoxLayout(TriviaPanel, BoxLayout.Y_AXIS));
        
        
        //Import Image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\TriviaBackground.jpg");
        //Make background label
        JLabel back=new JLabel(background);
        //Set alignment of label
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set background label layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add Label
        TriviaPanel.add(back);
        		
        //Create Space label
		JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		//Set space size
		space1.setFont (space1.getFont ().deriveFont (300.0f));
		//Set alignment
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Add space
		back.add(space1);
		
        //Create button for start game
        JButton start= new JButton("START GAME");
        //Add button
        back.add(start);
        //Set color to white
        start.setBackground(Color.WHITE);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        start.setFont (font2.deriveFont (35.0f));
        
        //Add Rules Button
        JButton rules= new JButton("READ RULES");
        //Set color to white
        rules.setBackground(Color.WHITE);
        back.add(rules);
        rules.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size 
        rules.setFont (font2.deriveFont (35.0f));
        
        //Add exit button
        JButton exit= new JButton("EXIT");
        back.add(exit);
        //Set color to white
        exit.setBackground(Color.WHITE);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set Font size
        exit.setFont (font2.deriveFont (35.0f));
        

        //Adding Panel to main frame
        TriviaMain.add(TriviaPanel);
        //Set location of frame
        TriviaMain.setLocationRelativeTo(null);
        //Set frame to be visible
        TriviaMain.setVisible(true);
       
        //If the user clicks the start button
       start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close main frame
				TriviaMain.setVisible(false);
				//Call question 1 method
				Question1();
				
				
				
			}
			
		});
       //If the user clicks the rules button
       rules.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close main frame
				TriviaMain.setVisible(false);
				//Call rules method
				Rules();
				
				
				
			}
			
		});
       //If the use clicks the exit button
       exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close main frame
				TriviaMain.setVisible(false);
				//Exit program
				System.exit(0);
				
				
				
			}
			
		});
    }
    
    //This method displays all the rules in a GUI
    public static void Rules(){
    	//Create RuleS Main Frame
    	JFrame RulesFrame = new JFrame("Rules");
    	RulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//Set size of frame
    	RulesFrame.setSize(1000, 730);

        //Creating the main panel
        JPanel RulesPanel = new JPanel(); 
        //Set layout of panel
        RulesPanel.setLayout(new BoxLayout(RulesPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Rules.jpg");
        //Create label for image
        JLabel back=new JLabel(background);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add label to main panel
        RulesPanel.add(back);		
		
        //Create space label
		JLabel space1=new JLabel(" ");
		space1.setBorder(border1);
		//Set size of space
		space1.setFont (space1.getFont ().deriveFont (150.0f));
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Add the space 
		back.add(space1);
		
		//Add First rule label
		JLabel rule1=new JLabel("1. Welcome to Trivia, Game made by Sanje and Zain");
		//Set font and font size
		rule1.setFont (font2.deriveFont (25.0f));
		back.add(rule1);
        rule1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Create space label
        JLabel space2=new JLabel(" ");
		space2.setBorder(border1);
		//Set size of space
		space2.setFont (font2.deriveFont (10.0f));
		//Add the space 
		back.add(space2);
        
		//Add Second rule label
		JLabel rule2=new JLabel("2. You’ll be given 10 random questions, answer them carefully.");
		//Set font size
		rule2.setFont (font2.deriveFont (25.0f));
		back.add(rule2);
        rule2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Create space label
        JLabel space3=new JLabel(" ");
		space3.setBorder(border1);
		//Set font size
		space3.setFont (space3.getFont ().deriveFont (10.0f));
		back.add(space3);
		
		//Add third rule
        JLabel rule3=new JLabel("3. You may exit the game at any time.");
        //Set font size
		rule3.setFont (font2.deriveFont (25.0f));
		back.add(rule3);
        rule3.setAlignmentX(Component.CENTER_ALIGNMENT);   
        
        //Create space label
        JLabel space4=new JLabel(" ");
		space4.setBorder(border1);
		//Set space size
		space4.setFont (space4.getFont ().deriveFont (10.0f));
		back.add(space4);
        
		//Add fourth rule
        JLabel rule4=new JLabel("4. For every question you answer correctly, you’ll be awarded 1 ticket.");
        //Set Font size
		rule4.setFont (font2.deriveFont (25.0f));
		back.add(rule4);
        rule4.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        //Add Space Label
        JLabel space5=new JLabel(" ");
		space5.setBorder(border1);
		//Set Space size
		space5.setFont (space5.getFont ().deriveFont (10.0f));
		back.add(space5);
        
		//Add fifth rule label
        JLabel rule5=new JLabel("5. Good Luck and Have Fun!");
        //Set font size
		rule5.setFont (font2.deriveFont (25.0f));
		back.add(rule5);
        rule5.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        //Add space label
        JLabel space6=new JLabel(" ");
		space6.setBorder(border1);
		//Set space label
		space6.setFont (space6.getFont ().deriveFont (10.0f));
		back.add(space6);
        
        //Add begin button
        JButton menu= new JButton("Return to Game Menu");
        back.add(menu);
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        menu.setFont (font2.deriveFont (35.0f));
        
        
        //Adding panel to main frame
       RulesFrame.add(RulesPanel);
       //Set frame location
       RulesFrame.setLocationRelativeTo(null);
       //Set frame visible
       RulesFrame.setVisible(true);
       
       
       //If the user clicks exit
       menu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close main frame 
				RulesFrame.setVisible(false);
				//Call the main method
				System.exit(0);
				
				
				
			}
			
		});
    	
    }
    
    //Question 1 method
    public static void Question1(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 1");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question1.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[0]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[0]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[0]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[0]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[0]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        //Set color
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        //If the user 
		        if (Questions[questionnums[0]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
		        
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question2();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        //Set color
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[0]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question2();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        //Set color
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[0]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question2();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        //Set color
		        AnswerCheckPanel.setBackground(Color.red);
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[0]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question2();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 2 method
    public static void Question2(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 2");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question2.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[1]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[1]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[1]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[1]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[1]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[1]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question3();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[1]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question3();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[1]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question3();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[1]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question3();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 3 method
    public static void Question3(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 3");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question3.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[2]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[2]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[2]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[2]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[2]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[2]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question4();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[2]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question4();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[2]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question4();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        //Set color
		        AnswerCheckPanel.setBackground(Color.red);
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[2]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question4();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 4 method
    public static void Question4(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 4");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question4.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 4
		JLabel label1=new JLabel(Questions[questionnums[3]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[3]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[3]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[3]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[3]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[3]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question5();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[3]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question5();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[3]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question5();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[3]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question5();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 5 method
    public static void Question5(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 5");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question5.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[4]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[4]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[4]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[4]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[4]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[4]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question6();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[4]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question6();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[4]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question6();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[4]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question6();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 6 method
    public static void Question6(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 6");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question6.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[5]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[5]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[5]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[5]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[5]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[5]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question7();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[5]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question7();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[5]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question7();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[5]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question7();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 7 method
    public static void Question7(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 7");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question7.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[6]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[6]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[6]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[6]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[6]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[6]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question8();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[6]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question8();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[6]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question8();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[6]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question8();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 8 method
    public static void Question8(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 8");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question8.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[7]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[7]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[7]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[7]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[7]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		       
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[7]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question9();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[7]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question9();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[7]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question9();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[7]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question9();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }    
    
    //Question 9 method
    public static void Question9(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 9");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question9.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 1
		JLabel label1=new JLabel(Questions[questionnums[8]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[8]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[8]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[8]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[8]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[8]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question10();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[8]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question10();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[8]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question10();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[8]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						Question10();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    //Question 10 method
    public static void Question10(){
    	//Creating the Frame
        JFrame QuestionFrame = new JFrame("Question 10");
        QuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set frame size
        QuestionFrame.setSize(1000, 730);

        //Create the main panel
        JPanel QuestionPanel = new JPanel(); 
        //Set layout of panel
        QuestionPanel.setLayout(new BoxLayout(QuestionPanel, BoxLayout.Y_AXIS));
        
        //Import image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\Question10.jpg");
        //Create the background Label
        JLabel back=new JLabel(background);
        //Set alignment
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to Box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add background to panel
        QuestionPanel.add(back);
        
		//Create space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border 
		space1.setBorder(border1);
		//Set X Alignment to center
		space1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Set space size
		space1.setFont (font2.deriveFont (250.0f));
		//Add label
		back.add(space1);
		
		//Create label containing question 10
		JLabel label1=new JLabel(Questions[questionnums[9]][0]);
		//Set font size
        label1.setFont (label1.getFont ().deriveFont (30.0f));
        //Add label
        back.add(label1);
        //Set X Alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border 
		space2.setBorder(border1);
		//Set space size
		space2.setFont (font2.deriveFont (20.0f));
		//Add label
		back.add(space2);
		
        //Create answer button 1
        JButton answer1= new JButton(Questions[questionnums[9]][1]);
        //Add button
        back.add(answer1);
        //Set X Alignment to center
        answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer1.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 2
        JButton answer2= new JButton(Questions[questionnums[9]][2]);
        //Add button
        back.add(answer2);
        //Set X Alignment to center
        answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer2.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 3
        JButton answer3= new JButton(Questions[questionnums[9]][3]);
        //Add button
        back.add(answer3);
        //Set X Alignment to center
        answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer3.setFont (font2.deriveFont (30.0f));
        
        //Create answer button 4
        JButton answer4= new JButton(Questions[questionnums[9]][4]);
        //Add button
        back.add(answer4);
        //Set X Alignment to center
        answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        answer4.setFont (font2.deriveFont (30.0f));
        
        //Create exit button
        JButton exit= new JButton("EXIT");
        //Add button
        back.add(exit);
        //Set X Alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (30.0f));
        

        //Adding Panel to main frame
        QuestionFrame.add(QuestionPanel);
        //Set location of main frame
        QuestionFrame.setLocationRelativeTo(null);
        //Set main frame visible
        QuestionFrame.setVisible(true);
        
        //If the user clicks answer 1 button
        answer1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close Question 1 frame
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[9]][5]!="1") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				
				//If the user clicks the next 
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						End();					
					}
					
				});
				
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 2 button
        answer2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[9]][5]!="2") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center 
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						End();					
					}
					
				});
				
				
			}
			
		});
        //If the user clicks answer 3 button
        answer3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
		        //Add label
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[9]][5]!="3") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		        //Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						End();					
					}
					
				});
				
				
				
				
				
			}
			
		});
        //If the user clicks answer 4 button
        answer4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QuestionFrame.setVisible(false);
				//Create Frame
				JFrame AnswerCheck = new JFrame("Answer Check");
				AnswerCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Set size of frame
				AnswerCheck.setSize(400, 400);

		        //Creating the panel 
		        JPanel AnswerCheckPanel = new JPanel(); 
		        //Set layout
		        AnswerCheckPanel.setLayout(new BoxLayout(AnswerCheckPanel, BoxLayout.Y_AXIS));
		        
		        
		        //Create Space label
		        JLabel space=new JLabel(" ");
				space.setBorder(border1);
				//Set font size
				space.setFont (space.getFont ().deriveFont (105.0f));
				//Add label
				AnswerCheckPanel.add(space);
		        
				//Create label
		        JLabel label;
		        if (Questions[questionnums[9]][5]!="4") {
		        	label =new JLabel("INCORRECT");
		        	AnswerCheckPanel.setBackground(Color.red);
		        } else {
		        	label =new JLabel("CORRECT");
		        	AnswerCheckPanel.setBackground(Color.GREEN);
		        	correctAnswer++;
		        }
				//Set font size
		        label.setFont (font2.deriveFont (60.0f));
		        //Add label
		        AnswerCheckPanel.add(label);
		     	//Set X Alignment to center
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				//Add Next Question button
				JButton nextQuestion= new JButton("Next Question");
				AnswerCheckPanel.add(nextQuestion);
				//Set X Alignment to center
				nextQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
				//Set font size
				nextQuestion.setFont (font2.deriveFont (15.0f));
				
				//Add panel to main frame
				AnswerCheck.add(AnswerCheckPanel);
				//Set main frame location
				AnswerCheck.setLocationRelativeTo(null);
				//Set frame visible
				AnswerCheck.setVisible(true);
				nextQuestion.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						AnswerCheck.setVisible(false);
						End();					
					}
					
				});
				
			}
			
		});
        //If the user clicks the exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close the main frame
				QuestionFrame.setVisible(false);
				//Call main method
				System.exit(0);				
			}
			
		});
       
       
    }
    
    
    private static boolean DuplicateQuestions(int q) {
    	int j=0;
    	boolean duplicated=false;
    	while (j<10) {
    		if (questionnums[j]==q) {
    			duplicated=true;
    		}
    		j++;
    	}
    	
    	return duplicated;
    }
    
    private static void RandomQuestions(){
        
    	int quesnum = 0;
    	int i=0;
    	do {
    		quesnum = rand.nextInt(19);
    		if (DuplicateQuestions(quesnum)==true) {
    			continue;
    		} else {
    			questionnums[i] = quesnum;
        		quesnum = -1;
    		}
    		i++;
    	}while (i<10);
    	
    	    	
    }
    
    //END method
    public static void End(){
    	//Creating the Frame
        JFrame endFrame = new JFrame("End");
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set Frame Size
        endFrame.setSize(1000,730);

        //Creating the panel 
        JPanel endPanel = new JPanel(); 
        //Set panel layout
        endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
        
        //Import Image for background
        ImageIcon background=new ImageIcon("C:\\Users\\sanje\\OneDrive\\Pictures\\Trivia\\End.jpg");
        //Create Background Label
        JLabel back=new JLabel(background);
        //Set alignment to center
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set layout to box layout
        back.setLayout(new BoxLayout(back, BoxLayout.Y_AXIS));
        //Add label
        endPanel.add(back);       
		
		//Create Space label
		JLabel space1=new JLabel(" ");
		//Set border to empty border
		space1.setBorder(border1);
		//Set space size
		space1.setFont (space1.getFont ().deriveFont (150.0f));
		//Add space
		back.add(space1);
		
		//Create label
		JLabel label1=new JLabel("Your Score was: " + correctAnswer + " / 10");
		//Set font size
        label1.setFont (font2.deriveFont (50.0f));
        //Add label
        back.add(label1);
        //Set alignment to center
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
		JLabel space2=new JLabel(" ");
		//Set border to empty border
		space2.setBorder(border1);
		//Set space size
		space2.setFont (space2.getFont ().deriveFont (20.0f));
		//Add space
		back.add(space2);
		
		//Create label
		JLabel label2=new JLabel("Tickets Earned: " + (correctAnswer*15));
		//Set font size
		label2.setFont (font2.deriveFont (50.0f));
		//Add label
		back.add(label2);
		//Set alignment to center
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Create space label
        JLabel space3=new JLabel(" ");
        //Set border to empty border
		space3.setBorder(border1);
		//Set space size
		space3.setFont (space3.getFont ().deriveFont (20.0f));
		//Add space
		back.add(space3);
		
		//Create label
		JLabel label3=new JLabel("Hope You Had Fun!");
		//Set font size
		label3.setFont (font2.deriveFont (50.0f));
		//Add label
		back.add(label3);
		//Set alignment to center
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Create space label
        JLabel space4=new JLabel(" ");
        //Set border to empty border
        space4.setBorder(border1);
		//Set space size
        space4.setFont (space4.getFont ().deriveFont (30.0f));
		//Add space
		back.add(space4);
		
        //Create button to play again
        JButton playAgain= new JButton("Return to Main Menu");
        //Add button
        back.add(playAgain);
        //Set alignment to center
        playAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        playAgain.setFont (font2.deriveFont (40.0f));
        
        //Create button to exit
        JButton exit= new JButton("EXIT GAME");
        //Add button
        back.add(exit);
        //Set alignment to center
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Set font size
        exit.setFont (font2.deriveFont (40.0f));
        

        //Adding panel to frame
        endFrame.add(endPanel);
        //Set frame location
        endFrame.setLocationRelativeTo(null);
        //Set frame visible
        endFrame.setVisible(true);
        //If the user clicks play again button
        playAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close main frame
				endFrame.setVisible(false);
				//Call main method
				main(null);			
			}
			
		});
        
      //If the user clicks exit button
        exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Close main frame
				endFrame.setVisible(false);
				System.exit(0);				
			}
			
		});
    }

    
    
    
    
}