package com.semphil.ui;

/*
 *	Name of Class: DepartmentMgmtPanel.java
 *		This is the class for the GUI of the Department Management Panel. 
 *		It contains the table where all data of entity "Department" is shown.
 */

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.semphil.bean.*;
import com.semphil.repo.*;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class InputMgmtPanel extends JPanel {
	
	private JTable tblInput;
	protected InputAddForm inputAddForm;
	protected InputViewForm inputViewForm;
	protected InputTableModel departmentTableModel;
	protected DepartmentRepo departmentRepo;

	public InputMgmtPanel() {
		setMinimumSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(1000, 550));
		setBackground(SystemColor.control);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Linking the Add and View Form Dialogs to this Management Panel
		inputAddForm = new InputAddForm();
		inputAddForm.inputMgmtPanel = this;
		inputViewForm = new InputViewForm();
		inputViewForm.inputMgmtPanel = this;
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setAlignmentY(Component.TOP_ALIGNMENT);
		pnlHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlHeader.setPreferredSize(new Dimension(1000, 50));
		pnlHeader.setMaximumSize(new Dimension(1000, 1000));
		pnlHeader.setBorder(new EmptyBorder(2, 2, 2, 2));
		pnlHeader.setBackground(SystemColor.control);
		add(pnlHeader);
		pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
		
		JLabel lblHeader = new JLabel("REGISTRATION MANAGEMENT PANEL");
		pnlHeader.add(lblHeader);
		lblHeader.setFont(new Font("Helvetica LT Std Cond", Font.BOLD, 30));
		
		JPanel pnlBtns = new JPanel();
		pnlHeader.add(pnlBtns);
		pnlBtns.setBackground(SystemColor.control);
		pnlBtns.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlBtns.setMaximumSize(new Dimension(700, 700));
		pnlBtns.setPreferredSize(new Dimension(500, 50));
		
		JButton btnView = new JButton("VIEW FORM");
		btnView.setMinimumSize(new Dimension(150, 25));
		/*btnView.setMinimumSize(new Dimension(100, 35));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = tblDepartment.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(null, "Please select a department!", "WARNING!", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				int dept_id = (int) departmentTableModel.getValueAt(rowIndex, 0);
				Department department = departmentRepository.getByDepartmentID(dept_id);
				
				departmentViewForm.viewDataInDialog(department);
				departmentViewForm.setVisible(true);
			}
		});*/
		btnView.setPreferredSize(new Dimension(150, 35));
		btnView.setMaximumSize(new Dimension(150, 35));
		btnView.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		pnlBtns.add(btnView);
		
		JButton btnAdd = new JButton("NEW FORM");
		btnAdd.setMinimumSize(new Dimension(150, 35));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//departmentAddForm.setVisible(true);
			}
		});
		btnAdd.setPreferredSize(new Dimension(150, 35));
		btnAdd.setMaximumSize(new Dimension(150, 35));
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		pnlBtns.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		// Linking the JTable to this Management Panel
		/*tblDepartment = new JTable();
		tblDepartment.setRowHeight(20);
		tblDepartment.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollPane.setViewportView(tblDepartment);
		
		// Using the created Table Model as architecture for the JTable
		departmentTableModel = new DepartmentTableModel();
		departmentTableModel.departmentMgmtPanel = this;
		tblDepartment.setModel(departmentTableModel);*/

	}
	
	// Method that would link its repository to this management panel
	public void setDepartmentRepo(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo;
	}
	
	// LINK OTHER REPOSITORIES HERE

}