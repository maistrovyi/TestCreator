package com.gui;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.model.UnswerModel;

public class AnswerPanel extends HeaderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4183283814762400822L;

	JTable table;

	int rowsNum;
	
	ArrayList<String> answers = new ArrayList<>();

	public AnswerPanel(String title, int num) {
		super(title);
		rowsNum = num;
		table = new JTable(num , 2) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 2055520964197744867L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 0 ? false : true;
			}

			@Override
			public void setRowHeight(int rowHeight) {
				super.setRowHeight(20);
			}

		};
		initTable();
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
	}

	private void initTable() {
		for (int i = 1; i <= rowsNum; i++) {
			table.setValueAt(i, i - 1, 0);
		}
		table.setTableHeader(null);
//		table.getColumnModel().getColumn(0).setPreferredWidth(34);
//		table.getColumnModel().getColumn(1).setPreferredWidth(534);
	}

	public boolean validateValue() {
		answers.clear();
		for (int i = 0; i < rowsNum; i++) {
			table.getCellEditor(i, 1).stopCellEditing();
			String item = (String) table.getValueAt(i, 1);
			if (isEmpty(item)) {
				table.setRowSelectionInterval(i, i);
				table.setColumnSelectionInterval(1, 1);
				table.requestFocus();
				return false;
			} else {
				answers.add(item);
			}
		}
		return true;
	}

	private boolean isEmpty(String str) {
		return str == null || str.equals("");
	}

	public ArrayList<UnswerModel> getAnswers() {
		ArrayList<UnswerModel> list = new ArrayList<>();
		for (String str : answers) {
			list.add(new UnswerModel(answers.indexOf(str), str, false));
		}
		return list;
	}
}
