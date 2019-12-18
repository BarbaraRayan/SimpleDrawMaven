/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.DrawingPanel;
import View.MainFrame;
import java.awt.event.ActionEvent;

/**
 *
 * @author rbarbara
 */
public class MainFrameController extends DrawingPanel {
    
    MainFrame myFrame;
    public  MainFrameController(){
        myFrame = new MainFrame();
    
        myFrame.getMySelectButton().addActionListener((ActionEvent e) -> {
            myFrame.getMyDrawingPanel().activateSelectionTool();
        });
                
	myFrame.getMyLineButton().addActionListener((ActionEvent e) -> {
            myFrame.getMyDrawingPanel().activateLineTool();
        });

	myFrame.getMyCircleButton().addActionListener((ActionEvent e) -> {
            myFrame.getMyDrawingPanel().activateCircleTool();
        });
    
    }
        public MainFrame getFrame(){
            return myFrame;
        }
    
    
    
}