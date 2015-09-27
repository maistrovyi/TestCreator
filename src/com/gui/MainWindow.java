package com.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.core.TestDataController;
import com.core.UIControlable;
import com.core.utils.GsonUtil;
import com.model.QuestionModel;

public class MainWindow extends JFrame implements UIControlable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestPanel fullPanel;
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = getFileMenu();
	JTextField field;
	JOptionPane optionPane;

	public int counter = 1; // using by button "next"

	private JMenu getFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(new MenuPressActionListener(MenuButtonType.NEW, this).getMenuItem());
		menu.addSeparator();
		JMenuItem openMenuItem = new MenuPressActionListener(MenuButtonType.OPEN, this).getMenuItem();
		openMenuItem.setEnabled(false);
		menu.add(openMenuItem);
		menu.add(new MenuPressActionListener(MenuButtonType.EXIT, this).getMenuItem());
		return menu;
	}

	private void createNavButton() {

	}

	private void setupMainWindowWithMenu() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 710);
		setLocationRelativeTo(null);

		super.setJMenuBar(menuBar);
		menuBar.add(getFileMenu());
	}

	public MainWindow() {
		super("TestCreator");

		setupMainWindowWithMenu();
	}

	@Override
	public void onNewTestPressed() {
		menuBar.setVisible(false);
		build();

	}
	

	private void build() {
		setResizable(false);
		fullPanel = new TestPanel(this);
		add(fullPanel);
	}

	private void configure() {
		// putFrameInTheCenterOfTheScreen();
	}

	@Override
	public void onNextTestPressed() {
		if (fullPanel.body.answerPanel.validateValue()) {
			checkSelectedCorrectAnser();
			QuestionModel newQuestion = new QuestionModel(counter, fullPanel.doubleHeaderPanel.getQuestion(),
					fullPanel.doubleHeaderPanel.getAnswerNumber());
			newQuestion.setContainer(fullPanel.body.answerPanel.getAnswers());
			int correctIndex = fullPanel.body.shooserPanel.getCorrectAnswer();
			newQuestion.setCorrectAnswer(correctIndex);
			TestDataController.getInstance().addNewQuestion(newQuestion);
			prepare();
			counter++;
		}
	}

	private void prepare(){
		fullPanel.remove(fullPanel.body);
		fullPanel.doubleHeaderPanel.prepareToNext();
		revalidate();
		repaint();
	}
	private void checkSelectedCorrectAnser() {
		fullPanel.body.shooserPanel.validateValue();
	}

	@Override
	public void onPrevTestPressed() {

	}

	@Override
	public void onFinishTestPressed() {
		onNextTestPressed();
		GsonUtil.saveGsonTestToFile();
		System.exit(0);
	}

	@Override
	public void onNumUnswersInput(int num) {
		fullPanel.createTestBodyPart(num);
		repaint();
		revalidate();
	}
}