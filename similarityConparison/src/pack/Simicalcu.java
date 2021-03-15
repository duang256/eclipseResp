package pack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
 
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;
 
public class Simicalcu {
 
    public static void main(final java.lang.String[] args) {
        java.awt.EventQueue.invokeLater(new java.lang.Runnable(){//awt�ǵ��߳�ģʽ�ģ�����awt�����ֻ�����Ƽ���ʽ���¼������߳��з��ʣ��Ӷ���֤���״̬����ȷ��
                public void run(){
                    final JFrame frame = new JFrame("�ַ������ƶȼ���");//����JFrame
                    final JLabel tag = new JLabel("��ʾ������ѡ���ļ���ťѡ����Ƚ��ļ�����ֱ�����ı����������ļ���");//��ʾLabel
                   //�ļ�һ
                    final JButton load = new JButton("ѡ���ļ�һ:");//ѡ���ļ�Button
                    final JLabel filename = new JLabel("");//�ļ�·��
                    final JTextArea textarea = new JTextArea(6, 20);//�ı���
                    textarea.setLineWrap(true);//����Ϊ�Զ�����
                    textarea.setWrapStyleWord(true);//�������ڱ߾ദ�Զ�����
                    final JScrollPane scroller = new JScrollPane(textarea);//������Ч��
                    //�����ļ�һ���¼�����
                    load.addActionListener(new ActionListener(){
                            private JFileChooser filechooser = null;
                            private DefaultEditorKit kit = new DefaultEditorKit();
                            public void actionPerformed(ActionEvent e){
                                if (filechooser == null) {
                                	//����Ĭ���ļ�ѡ��·��Ϊ����·��
                                    filechooser = new JFileChooser(System.getProperty("user.home"));
                                }
                                //�����ļ����ͣ����� ��txt�ļ���doc�ĵ�
                                filechooser.setFileFilter(new FileNameExtensionFilter("text file","txt","text","doc","docs"));
                                if (filechooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                                	//��ʾ�ļ�·��
                                    filename.setText(filechooser.getSelectedFile().getAbsolutePath());
                                    FileReader reader = null;
                                    //���ļ����ݶ�ȡ��textarea����&�쳣����
                                    try {
                                        reader = new FileReader(filechooser.getSelectedFile());
                                        textarea.setText("");
                                        kit.read(reader,textarea.getDocument(),0);
                                    } catch (Exception xe) {
                                        System.err.println(xe.getMessage());
                                    } finally {
                                        if (reader != null) {
                                            try {
                                                reader.close();
                                            } catch (IOException ioe) {
                                                System.err.println(ioe.getMessage());
                                            }
                                        }
                                    }
                                    textarea.setCaretPosition(0);//��꽹��
                                }
                                return;
                            }
                        });
                    
                    //�ļ���
                    final JButton load2 = new JButton("ѡ���ļ���:");
                    final JLabel filename2 = new JLabel("");
                    final JTextArea textarea2 = new JTextArea(6, 20);
                    textarea2.setLineWrap(true);
                    textarea2.setWrapStyleWord(true);
                    final JScrollPane scroller2 = new JScrollPane(textarea2);
                    //�����ļ������¼�����
                    load2.addActionListener(new ActionListener(){
                            private JFileChooser filechooser2 = null;
                            private DefaultEditorKit kit2 = new DefaultEditorKit();
                            public void actionPerformed(ActionEvent e){
                                if (filechooser2 == null) {
                                    filechooser2 = new JFileChooser(System.getProperty("user.home"));
                                }
                                filechooser2.setFileFilter(new FileNameExtensionFilter("text file","txt","text","doc","docs"));
                                if (filechooser2.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                                    filename2.setText(filechooser2.getSelectedFile().getAbsolutePath());
                                    FileReader reader2 = null;
                                    try {
                                        reader2 = new FileReader(filechooser2.getSelectedFile());
                                        textarea2.setText("");
                                        kit2.read(reader2,textarea2.getDocument(),0);
                                    } catch (Exception xe2) {
                                        System.err.println(xe2.getMessage());
                                    } finally {
                                        if (reader2 != null) {
                                            try {
                                                reader2.close();
                                            } catch (IOException ioe2) {
                                                System.err.println(ioe2.getMessage());
                                            }
                                        }
                                    }
                                    textarea2.setCaretPosition(0);
                                }
                                return;
                            }
                        });
                    
                    //��ʾ�������ݵ�textarea
                    final JTextArea textarea_res = new JTextArea(6, 20);
                    textarea_res.setLineWrap(true);
                    textarea_res.setWrapStyleWord(true);
                    final JScrollPane scroller_res = new JScrollPane(textarea_res);
                   //����textarea_res͸��
                    textarea_res.setOpaque(false);
                    scroller_res.setOpaque(false);
                    scroller_res.getViewport().setOpaque(false);
                    
                    //textarea��textarea2���ݸı��¼�,ɾ���ļ�·������������
                    textarea.addKeyListener(new KeyAdapter(){
                    	public void keyPressed(KeyEvent e) {
                    		filename.setText("");
                    		textarea_res.setText("");
                    		 }
                    });
                    textarea2.addKeyListener(new KeyAdapter(){
                    	public void keyPressed(KeyEvent e) {
                    		filename2.setText("");
                    		textarea_res.setText("");
                    		 }
                    });
                    
                    //���㣬�˳���ť
                    final JButton start = new JButton("��ʼ����");
                    //��ʼ�������ƶ��¼�
                    start.addActionListener(new ActionListener(){
                    	public void actionPerformed(ActionEvent e) {
                    		 String temp_strA = textarea.getText();
                    	     String temp_strB = textarea2.getText();
                    	     String strA,strB;
                    	     //�������textarea����Ϊ���Ҷ���ȫΪ���ţ���������ƶȼ��㣬������ʾ�û������������ݻ�ѡ���ļ�
                    	     if(!(Computeclass.removeSign(temp_strA).length() == 0 && Computeclass.removeSign(temp_strB).length() == 0)){
                    	    	 if(temp_strA.length() >= temp_strB.length())
                    	    	 {
                    	    		 strA = temp_strA;
                    	    		 strB = temp_strB;
                    	    	 }else{
                    	    		 strA = temp_strB;
                    	    		 strB = temp_strA;
                    	    	 }
                    	    	 double result = Computeclass.SimilarDegree(strA, strB); 
                    	    	 //��ʾ����������textarea_res
                    	    	 textarea_res.setText("���Ƶ�����Ϊ��"+Computeclass.longestCommonSubstring(strA, strB));
                    	    	 //���
                         		JOptionPane.showMessageDialog(null, "    ���ƶ�Ϊ��" + Computeclass.similarityResult(result), "�� �� �� ��", JOptionPane.PLAIN_MESSAGE);
                    	     }else{
                    	    	 JOptionPane.showMessageDialog(null, "     ���ã���������ȷ���ݣ� ", "��    ʾ", JOptionPane.ERROR_MESSAGE);
                    	     }
	                    }
                    });
                    final JButton cancle = new JButton("��        ��");
                    //�˳��¼�
                    cancle.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
	                    		frame.dispose();//�ͷŴ�����ռ��Դ
		                    	System.exit(0);//�˳�����
	                        }
	                    });
                    
                    
                    //�ܲ���
                    //�ļ�һnorth
                    final Box north = Box.createVerticalBox();//������
                    north.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));//�߾�
                    north.add(tag);
                    north.add(Box.createVerticalStrut(10));
                    north.add(load);
                    north.add(Box.createVerticalStrut(5));
                    north.add(filename);
                    north.add(scroller);
                    frame.add(north,BorderLayout.NORTH);
                    //�ļ���center
                    final Box center = Box.createVerticalBox();
                    center.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                    center.add(load2);
                    center.add(Box.createVerticalStrut(5));
                    center.add(filename2);
                    center.add(scroller2);
                    center.add(scroller_res);
                    frame.add(center,BorderLayout.CENTER);
                    //south
                    final Box south = Box.createHorizontalBox();
                    south.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                    south.add(Box.createHorizontalGlue());//��ť������ʾ
                    south.add(start);
                    south.add(Box.createHorizontalStrut(20));//ˮƽ���
                    south.add(cancle);
                    south.add(Box.createVerticalStrut(5));
                    frame.add(south,BorderLayout.SOUTH);
                    frame.pack();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ���˳���ʽ
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                }
            });
    }
}
