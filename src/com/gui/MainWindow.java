package com.gui;

import java.awt.Toolkit;
import java.io.File;
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

	JOptionPane optionPane;

	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	static int counter = 1;

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

	private JMenu getHelpMenu() {
		JMenu help = new JMenu("Help");
		help.add(new MenuPressActionListener(MenuButtonType.ABOUT, this).getMenuItem());
		return help;
	}

	private void createNavButton() {

	}

	private void setupMainWindowWithMenu() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 710);
		setLocationRelativeTo(null);
		super.setJMenuBar(menuBar);
		menuBar.add(getFileMenu());
		menuBar.add(getHelpMenu());
	}

	public MainWindow() {
		super("Test Creator");
		setIconImage(toolkit.getImage("resources" + File.separator + "images/icon.png"));
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
	}

	@Override
	public void onNextTestPressed() {
		if (fullPanel.body.answerPanel.validateValue()) {
			checkSelectedCorrectAnser();
			QuestionModel newQuestion = new QuestionModel(counter, fullPanel.doubleHeaderPanel.getQuestion(),
					fullPanel.doubleHeaderPanel.getAnswerNumber());
			newQuestion.setContainer(fullPanel.body.answerPanel.getAnswers());
			int correctIndex = fullPanel.body.shooserPanel.getCorrectAnswer();
//			fullPanel.doubleHeaderPanel.question.
			newQuestion.setCorrectAnswer(correctIndex);
			TestDataController.getInstance().addNewQuestion(newQuestion);
			prepare();
			counter++;
		}
	}

	private void prepare() {
		fullPanel.remove(fullPanel.body);
		fullPanel.doubleHeaderPanel.prepareToNext();
		onQuestionLenghtLess10();
		revalidate();
		repaint();
	}

	private void checkSelectedCorrectAnser() {
		fullPanel.body.shooserPanel.validateValue();
	}

	@Override
	public void onPrevTestPressed() {

	}

	private void finishMessage() {
		JOptionPane jOptionPane = new JOptionPane();
		JOptionPane.showMessageDialog(this, "Your file is here: " + GsonUtil.path, "Completed!",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	@Override
	public void onFinishTestPressed() {
		if (fullPanel.body.answerPanel.validateValue()) {
		onNextTestPressed();
		GsonUtil.saveGsonTestToFile();
		finishMessage();
		}
	}

	@Override
	public void onNumUnswersInput(int num) {
		fullPanel.footerPanel.enableButtons(true);
		fullPanel.createTestBodyPart(num);
		repaint();
		revalidate();
	}

	@Override
	public void onQuestionLenghtMore10() {
		//fullPanel.footerPanel.enableButtons(true);
	}

	@Override
	public void onQuestionLenghtLess10() {
		fullPanel.footerPanel.enableButtons(false);
	}
}