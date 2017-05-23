/**
 * 
 */
package gui;

import draw.DrawPanel;
import draw.EllipseTool;
import draw.LineTool;
import draw.PencilTool;
import draw.RectangleTool;
import draw.Tool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



/**
 * Creates GUI of the PowerPaint.
 * @author baimenov
 * @version November 23 2016
 */
public class PowerPaintGUI extends JFrame {
    
    private static final long serialVersionUID = 5756891741199164658L;
    
    /**
     * Initial JFrame dimension.
     */
    private static final Dimension FRAME_SIZE = new Dimension(400, 300);
    
    /**
     * Constant UW purple color.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    
    /**
     * Constant UW gold color.
     */
    private static final Color UW_GOLD = new Color(232, 211, 162);
    
    /**
     * List of four tools: line, pencil, rectangle, ellipse.
     */
    private static final Tool[] TOOL_LIST = {new LineTool(), new PencilTool(),
                                             new RectangleTool(), new EllipseTool()};
    
    /**
     * Drawing Panel.
     */
    private DrawPanel myPanel;
    
    /**
     * Initializes PowerPaintGUI and its title.
     */
    public PowerPaintGUI() {
        super("TCSS 305 - PowerPaint");
        final JToolBar toolBar1 = createToolBar();
        add(toolBar1, BorderLayout.SOUTH);
        myPanel = new DrawPanel();
        setJMenuBar(createMenuBar());
        add(myPanel, BorderLayout.CENTER);
    }
    
    /**
     * Displays the PowerPaint.
     */
    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_SIZE);
        final ImageIcon img = new ImageIcon("images/jframe_icon.png");
        setIconImage(img.getImage());
        final Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((int) (kit.getScreenSize().getWidth() / 2 - getWidth() / 2),
                    (int) (kit.getScreenSize().getHeight() / 2 - getHeight() / 2));
        pack();
        setVisible(true);
    }
    
    /**
     * Create toolBar with all its components and returns it.
     * @return Returns toolBar.
     */
    private JToolBar createToolBar() {
        final JToolBar bar = new JToolBar();
        bar.addSeparator();
        
        final ButtonGroup btngrp = new ButtonGroup();
        
        final JToggleButton pencil = new JToggleButton("Pencil",
                                     new ImageIcon("images/pencil_bw.gif"));
        final JToggleButton rectangle = new JToggleButton("Rectangle",
                                        new ImageIcon("images/rectangle_bw.gif"));
        final JToggleButton ellipse = new JToggleButton("Ellipse",
                                      new ImageIcon("images/ellipse_bw.gif"));
        final JToggleButton line = new JToggleButton("Line",
                                   new ImageIcon("images/line.gif"));
        
        final JToggleButton[] jtbArray = {line, pencil, rectangle, ellipse};
        
        for (int i = 0; i < jtbArray.length; i++) {
            btngrp.add(jtbArray[i]);
            bar.add(jtbArray[i]);
            final Tool tool = TOOL_LIST[i];
            jtbArray[i].addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent theEvent) {
                    myPanel.chooseTool(tool);
                }
            });
        }
        
        pencil.setMnemonic(KeyEvent.VK_P);
        rectangle.setMnemonic(KeyEvent.VK_R);
        ellipse.setMnemonic(KeyEvent.VK_E);
        line.setMnemonic(KeyEvent.VK_L);
        
        btngrp.clearSelection();
        btngrp.setSelected(line.getModel(), true);
        
        return bar;
    }
    
    /**
     * Creates menuBar with all its components and returns it.
     * @return Returns menuBar.
     */
    private JMenuBar createMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
        final JMenu[] menuBarItems = {new JMenu("File"), new JMenu("Options"),
                                      new JMenu("Tools"), new JMenu("Help")};
        for (int i = 0; i < menuBarItems.length; i++) {
            final int mnemonic = (int) menuBarItems[i].getText().toUpperCase().charAt(0);
            menuBarItems[i].setMnemonic(mnemonic);
            menuBar.add(menuBarItems[i]);
        }
        
        final JMenuItem quit = new JMenuItem("Quit");
        final JMenuItem clear = new JMenuItem("Clear");
        quit.setMnemonic(KeyEvent.VK_Q);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                dispatchEvent(new WindowEvent(PowerPaintGUI.this,
                                              WindowEvent.WINDOW_CLOSING));
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.clearAll();
            }
        });
        clear.setMnemonic(KeyEvent.VK_C);
        clear.setEnabled(true);
        menuBarItems[0].add(clear);
        menuBarItems[0].addSeparator();
        menuBarItems[0].add(quit);
        final ButtonGroup btngrp = new ButtonGroup();
        final JRadioButtonMenuItem[] list = {new JRadioButtonMenuItem("Line"),
                                             new JRadioButtonMenuItem("Pencil"),
                                             new JRadioButtonMenuItem("Rectangle"),
                                             new JRadioButtonMenuItem("Ellipse")};
        for (int i = 0; i < list.length; i++) {
            final StringBuilder builder = new StringBuilder("images/");
            final String toAppend = list[i].getText().toLowerCase();
            builder.append(toAppend);
            if (i != 0) {
                builder.append("_bw");
            }
            builder.append(".gif");
            list[i].setIcon(new ImageIcon(builder.toString()));
            final int mnemonic = (int) list[i].getText().charAt(0);
            list[i].setMnemonic(mnemonic);
            btngrp.add(list[i]);
        }
        menuBarItems[1].add(createThickness());
        menuBarItems[1].addSeparator();
        final JMenuItem drawColor = new JMenuItem("Draw Color...");
        drawColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color chosenColor = JColorChooser.showDialog(null,
                                                       "Choose Draw Color", UW_PURPLE);
                myPanel.setDrawColor(chosenColor);
            }
        });
        final JMenuItem fillColor = new JMenuItem("Fill Color...");
        fillColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color chosenColor = JColorChooser.showDialog(null,
                                                       "Choose Fill Color", UW_GOLD);
                myPanel.setFillColor(chosenColor);
            }
        });
        final JCheckBoxMenuItem fill = new JCheckBoxMenuItem("Fill");
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.setFilled(fill.getState());
            }
        });
        drawColor.setMnemonic(KeyEvent.VK_D);
        fillColor.setMnemonic(KeyEvent.VK_F);
        menuBarItems[1].add(drawColor);
        menuBarItems[1].addSeparator();
        menuBarItems[1].add(fillColor);
        menuBarItems[1].addSeparator();
        menuBarItems[1].add(fill);
        menuBarItems[2].add(list[0]);
        menuBarItems[2].add(list[1]);
        menuBarItems[2].add(list[2]);
        menuBarItems[2].add(list[3]);
        final JMenuItem about = new JMenuItem("About...");
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(PowerPaintGUI.this,
                            "TCSS 305 PowerPaint\nAutumn2016\nAlisher Baimenov",
                            "About", JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon("images/jframe_icon.png"));
            }
        });
        menuBarItems[3].add(about);
        
        return menuBar;
    }
    
    /**
     * Helper method that sets up the Thickness JMenu
     * and its inside components.
     * @return Returns JMenu Thickness.
     */
    private JMenu createThickness() {
        final JMenu thickness = new JMenu("Thickness");
        thickness.setMnemonic(KeyEvent.VK_T);
        final JSlider slider = new JSlider(0, 20, 1);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = slider.getValue();
                myPanel.setStroke(value);
            }
        });
        thickness.add(slider);
        return thickness;
    }
}
