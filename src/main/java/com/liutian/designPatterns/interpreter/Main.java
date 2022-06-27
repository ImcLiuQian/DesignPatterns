package com.liutian.designPatterns.interpreter;

import com.liutian.designPatterns.interpreter.language.Context;
import com.liutian.designPatterns.interpreter.language.InterpreterFacade;
import com.liutian.designPatterns.interpreter.language.Node;
import com.liutian.designPatterns.interpreter.language.ProgramNode;
import com.liutian.designPatterns.interpreter.treevisitior.ProgramVisitor;
import com.liutian.designPatterns.interpreter.turtle.TurtleCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main extends Frame implements ActionListener {
    /**
     * 让机器行走的命令
     */
    String ctrlCmd = "program repeat 4 repeat 3 go left end right end end";

    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField programTextField = new TextField(ctrlCmd);

    public Main(String title) {
        super(title);
        canvas.setExecutor(facade);
        setLayout(new BorderLayout());
        programTextField.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        parseAndExecute();
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == programTextField) {
            parseAndExecute();
        }
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText);
        canvas.repaint();
    }


    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
//            String text;
//            while ((text = reader.readLine()) != null) {
////                System.out.println("text = \"" + text + "\"");
//                Node node = new ProgramNode();
//                node.parse(new Context(text));
////                System.out.println("node = " + node);
////                System.out.println();
//                ProgramVisitor visitor = new ProgramVisitor();
//                visitor.visit((ProgramNode) node);
//                String javaCode = visitor.getJavaCode();
//                System.out.println(javaCode);
//            }
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    }
}
