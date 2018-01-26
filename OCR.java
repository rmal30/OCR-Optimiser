import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class OCR extends Frame {
	private static final long serialVersionUID = 1L;
	String path = "D:/Users/rmal29/Desktop/OCR";
	public static void main(String[] args) throws IOException {new OCR().startOCR();}
    JLabel status = new JLabel();
	final JPanel text = new JPanel();
    JTextArea OCR_text = new JTextArea(5, 60); 
    final JLabel newimage = new JLabel();
    final JLabel oldimage = new JLabel();
    boolean button_clicked = false;
    boolean button_clicked2 = false;
    JScrollPane scroll = new JScrollPane(OCR_text);
    final JFrame ui = new JFrame("OCR");
    double perheight = 0.50;
    double perwidth = 0.7;
    
    
    final JPanel query = new JPanel();
	final JPanel image = new JPanel();
	final JPanel cont = new JPanel();
	final JPanel dim = new JPanel();
	final JPanel tol = new JPanel();
	final JPanel tol2 = new JPanel();
	final JPanel col = new JPanel();
	final JPanel col2 = new JPanel();
	final JPanel checkbox = new JPanel();
	final JPanel color = new JPanel();
	final JPanel display = new JPanel();
    
    public void newline(){
    	query.add(Box.createVerticalStrut(15));
    }
    
    public void startOCR() throws IOException{
    	 OCR_text.setEditable(false);
    	 OCR_text.setLineWrap(true);
     	OCR_text.setWrapStyleWord(true);
     	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
     	
    	JLabel inl=new JLabel(); final JTextField Imgname=new JTextField(); final JButton imgbutton = new JButton(); 
    	JLabel cl = new JLabel(); final JTextField contrast=new JTextField(); 
    	JLabel sl = new JLabel(); final JTextField size=new JTextField(); 
    	final JLabel sqcol = new JLabel(); final JButton thresh = new JButton(); 
    	final JLabel sqcol2 = new JLabel(); final JButton thresh2 = new JButton();
    	final JColorChooser tcc = new JColorChooser(); 
    	final JColorChooser tcc2 = new JColorChooser();
    	final JLabel tl = new JLabel(); 
    	final JLabel tl2 = new JLabel();
    	final JLabel ol = new JLabel();
    	final JSpinner tolerance = new JSpinner(); 
    	final JSpinner tolerance2 = new JSpinner();
    	final JTextField rotate_value = new JTextField();
		final JCheckBox dothresh = new JCheckBox();
		final JCheckBox dothresh2 = new JCheckBox();
		final JCheckBox iscolor = new JCheckBox(); 
		final JCheckBox remnoise = new JCheckBox();
		final JCheckBox autothresh = new JCheckBox();
		final JCheckBox autothresh2 = new JCheckBox();
		final JCheckBox dorotate = new JCheckBox();
		final JCheckBox remglyph = new JCheckBox();
		final JButton submit = new JButton(); 
	
	query.add(image);
		image.add(inl); inl.setText("Image:");
		image.add(Imgname); Imgname.setText("PPE_logo.gif");
		image.add(imgbutton); imgbutton.setText("Draw image");
		newline();
	 
		
	
	query.add(tol); 
		tol.add(dothresh); dothresh.setText("Threshold:");
		sqcol.setEnabled(false); 
		thresh.setEnabled(false);
		tl.setEnabled(false); 
		tolerance.setEnabled(false);
		autothresh.setEnabled(false);
		tol.add(col);
			col.add(sqcol); sqcol.setOpaque(true); sqcol.setBackground(Color.gray); sqcol.setText("     ");
			col.add(thresh); thresh.setText("Pick");
			col.add(tl); tl.setText("Spread:");
			col.add(tolerance); tolerance.setValue(20);
		tol.add(autothresh);	autothresh.setText("Auto-threshold");
		newline();
		
		
	query.add(tol2); 
		tol2.add(dothresh2); dothresh2.setText("2nd threshold:");
		sqcol2.setEnabled(false); 
		thresh2.setEnabled(false);
		tl2.setEnabled(false); 
		tolerance2.setEnabled(false);
		autothresh2.setEnabled(false);
		dothresh2.setEnabled(false);
		tol2.add(col2);
			col2.add(sqcol2); sqcol2.setOpaque(true); sqcol2.setBackground(Color.gray); sqcol2.setText("     ");
			col2.add(thresh2); thresh2.setText("Pick");
			col2.add(tl2); tl2.setText("Spread:");
			col2.add(tolerance2); tolerance2.setValue(20);
		tol2.add(autothresh2);	autothresh2.setText("Auto-threshold");
		newline();
		
		
		query.add(dim);
			dim.add(sl); sl.setText("Size:");
			dim.add(size); size.setText("  1.0");
			
			dim.add(cl); cl.setText("Contrast:");
			dim.add(contrast);contrast.setText("  1.0");
			
			dim.add(dorotate); dorotate.setText("Rotate:"); dorotate.setForeground(Color.gray);
			dim.add(rotate_value);  rotate_value.setText("  0.0"); rotate_value.setEnabled(false);
		
		newline();
		
	query.add(checkbox);
		checkbox.add(iscolor); iscolor.setText("Color:"); iscolor.setSelected(true);
		checkbox.add(remnoise); remnoise.setText("Remove noise");
		checkbox.add(remglyph); remglyph.setText("Remove glyphs"); remglyph.setSelected(true);

	
	color.add(tcc); tcc.setVisible(false); tcc.setColor(Color.black);
	color.add(tcc2); tcc2.setVisible(false); tcc2.setColor(Color.black);
	display.add(oldimage);  
	display.add(newimage);
	
	text.setVisible(false);
	text.add(ol); ol.setText("Output:"); 
	text.add(scroll); 
	
	
	ui.add(query);
	ui.add(Box.createHorizontalStrut(100));
	ui.add(submit); submit.setText("Start OCR"); submit.setPreferredSize(new Dimension(100, 100));
	ui.add(status);
	ui.add(color);
	ui.add(display);
	ui.add(text);
   
	ui.setSize(1280,768);
	query.setLayout(new BoxLayout(query, BoxLayout.Y_AXIS));
		image.setLayout(new GridLayout());
		cont.setLayout(new GridLayout());
		dim.setLayout(new GridLayout());
	display.setLayout(new GridLayout(1,2));
	text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
	ui.setLayout(new FlowLayout());
	ui.setVisible(true);
	
	
	dorotate.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(dorotate.isSelected()){dorotate.setForeground(Color.black); rotate_value.setEnabled(true);}
			else{dorotate.setForeground(Color.gray); rotate_value.setEnabled(false);}
		}
	});
	
	dothresh.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(dothresh.isSelected()){
				sqcol.setEnabled(true); 
				thresh.setEnabled(true);
				tl.setEnabled(true); 
				tolerance.setEnabled(true);
				autothresh.setEnabled(true);
				sqcol.setBackground(tcc.getColor());
				dothresh2.setEnabled(true); 
				}
			else{
				sqcol.setEnabled(false); 
				thresh.setEnabled(false);
				tl.setEnabled(false); 
				tolerance.setEnabled(false);
				autothresh.setEnabled(false);
				sqcol.setBackground(Color.gray);
				tcc.setVisible(false);
				thresh.setText("Pick");
				button_clicked = false;
				sqcol2.setEnabled(false); 
				thresh2.setEnabled(false);
				tl2.setEnabled(false); 
				tolerance2.setEnabled(false);
				autothresh2.setEnabled(false);
				sqcol2.setBackground(Color.gray);
				tcc2.setVisible(false);
				thresh2.setText("Pick");
				button_clicked2 = false;
				dothresh2.setEnabled(false); 
			}
		}
	});
	
	dothresh2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(dothresh2.isSelected()){
				sqcol2.setEnabled(true); 
				thresh2.setEnabled(true);
				tl2.setEnabled(true); 
				tolerance2.setEnabled(true);
				autothresh2.setEnabled(true);
				sqcol2.setBackground(tcc2.getColor());
				}
			else{
				sqcol2.setEnabled(false); 
				thresh2.setEnabled(false);
				tl2.setEnabled(false); 
				tolerance2.setEnabled(false);
				autothresh2.setEnabled(false);
				sqcol2.setBackground(Color.gray);
				tcc2.setVisible(false);
				thresh2.setText("Pick");
				button_clicked2 = false;
			}
		}
	});
	
	autothresh.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(autothresh.isSelected()){
				
				sqcol.setEnabled(false); 
				thresh.setEnabled(false);
				tl.setEnabled(false); 
				tolerance.setEnabled(false);
				sqcol.setBackground(Color.gray);
				tcc.setVisible(false);
				thresh.setText("Pick");
				button_clicked = false;
				
			}
			else{
				sqcol.setEnabled(true); 
				thresh.setEnabled(true);
				tl.setEnabled(true); 
				tolerance.setEnabled(true);
				sqcol.setBackground(tcc.getColor());
			}
		}
	});
	
	autothresh2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(autothresh2.isSelected()){
				
				sqcol2.setEnabled(false); 
				thresh2.setEnabled(false);
				tl2.setEnabled(false); 
				tolerance2.setEnabled(false);
				sqcol2.setBackground(Color.gray);
				tcc2.setVisible(false);
				thresh2.setText("Pick");
				button_clicked2 = false;
				
			}
			else{
				sqcol2.setEnabled(true); 
				thresh2.setEnabled(true);
				tl2.setEnabled(true); 
				tolerance2.setEnabled(true);
				sqcol2.setBackground(tcc2.getColor());
			}
		}
	});
	
	
	imgbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String fullname = Imgname.getText();
			 BufferedImage img;
			try {
				img = ImageIO.read(new File(path + "/raw/" + fullname));
				 double imgwidth = ui.getWidth() * perwidth/2;
				 ImageIcon icon=new ImageIcon(img.getScaledInstance((int) imgwidth, (int) (ui.getHeight()*perheight),Image.SCALE_SMOOTH));
				 oldimage.setIcon(icon);
			} catch (IOException e1) {
				status.setText("Invalid file name");
			}
			
		}
		
	});
	tcc.getSelectionModel().addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
					sqcol.setBackground(tcc.getColor());
					
	      }
	    });
	
	tcc2.getSelectionModel().addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
					sqcol2.setBackground(tcc2.getColor());
					
	      }
	    });
	
		
			
	thresh.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(button_clicked == false){
				tcc.setColor(sqcol.getBackground());
				tcc.setVisible(true);
				thresh.setText("Select");
				button_clicked = true;
			}
			else{
				tcc.setVisible(false);
				thresh.setText("Pick");
				button_clicked = false;
			}
		}
		});
	
	thresh2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(button_clicked2 == false){
				tcc2.setColor(sqcol2.getBackground());
				tcc2.setVisible(true);
				thresh2.setText("Select");
				button_clicked2 = true;
			}
			else{
				tcc2.setVisible(false);
				thresh2.setText("Pick");
				button_clicked2 = false;
			}
			
	   
		}});
	
	submit.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			
			String fullname = Imgname.getText();
			String cont = contrast.getText();
			String rot = rotate_value.getText();
			String sizestring = size.getText();
			String[] name = null;
			double contrast, size, angle;
			try{
			contrast = Double.parseDouble(cont);
			size = Double.parseDouble(sizestring);
			angle = Double.parseDouble(rot);
			}
			catch(Exception e1){status.setText("Invalid input");return;}
			
			try {
				name = fullname.split("\\.");
				BufferedImage img = ImageIO.read(new File(path + "/raw/" + fullname));
				img.getData();
				
			} catch (IOException e1) {status.setText("Invalid file name");return;}
			
			Object tol = tolerance.getValue();
			Object tol2 = tolerance.getValue();
			int tolerance = Integer.parseInt(tol.toString());
			int tolerance2 = Integer.parseInt(tol2.toString());
			Color threshold = tcc.getColor();
			Color threshold2 = tcc2.getColor();
			boolean do_rotate = dorotate.isSelected()&& dorotate.isEnabled();
			boolean do_threshold = dothresh.isSelected() && dothresh.isEnabled();
			boolean do_threshold2 = dothresh2.isSelected() && dothresh2.isEnabled();
			boolean auto_threshold = autothresh.isSelected() && autothresh.isEnabled();
			boolean auto_threshold2 = autothresh2.isSelected() && autothresh2.isEnabled();
			boolean remove_glyphs = remglyph.isSelected() && remglyph.isEnabled();
			boolean use_filter = remnoise.isSelected() && remnoise.isEnabled();
			boolean Is_Color = iscolor.isSelected() && iscolor.isEnabled();
			
			 	tcc.setVisible(false);
			 	tcc2.setVisible(false);
				thresh.setText("Pick");
				thresh2.setText("Pick");
				button_clicked = false;
				button_clicked2 = false;
				OCR_text.setText("");
				
				try {
					OCR(path, fullname, name[0],contrast, size, tolerance, tolerance2 , Is_Color, threshold, threshold2, angle , auto_threshold,auto_threshold2, do_rotate,do_threshold, do_threshold2 , use_filter, remove_glyphs);
				} catch (IOException e1) {e1.printStackTrace();}
				
		}
		});
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

public void OCR(String path, String fullname,String name,double contrast,double size,int tolerance, int tolerance2 , boolean Is_Color, Color threshold, Color threshold2 ,double angle,boolean auto_threshold, boolean auto_threshold2, boolean rotate, boolean do_thresh,boolean do_thresh2, boolean use_filter, boolean remove_glyphs) throws IOException{
	int filtersize = 3;
	int states = 1;
	if(do_thresh){states++;}
	if(do_thresh2){states++;}
	if(use_filter){states++;}
	if(rotate){states++;}
	if(contrast!=1){states++;}
	File fnew=new File(path + "/raw/" + fullname);
	BufferedImage originalImage = ImageIO.read(fnew);
	int height = originalImage.getHeight();
	int width = originalImage.getWidth();
	int newheight = (int) (height*size);
	int newwidth = (int) (width*size);
	   double midw = newwidth/2;
	   double midh = newheight/2;
	int state = 0;
	long ared = 0, ablue = 0,agreen = 0 , agrey = 0;
	int r,g,b,a;
	int ired = 0,igreen = 0, iblue = 0, igrey = 0;
	int[][] image = null, count = null; 
	int[][][] blue = null, green = null, red = null, grey = null;
	BufferedImage RedImage=null, GreenImage=null, BlueImage = null, GreyImage = null, Image = null;
	int numblue[] = new int[256]; 
	int numgreen[] = new int[256]; 
	int numred[] = new int[256]; 
	int numgrey[] = new int[256];
	int[][] matrix = new int[filtersize][filtersize];
	try{
	if(Is_Color){
	blue = new int[newwidth][newheight][states];
	green = new int[newwidth][newheight][states];
	red = new int[newwidth][newheight][states];
	Image = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);
	RedImage = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);
	GreenImage = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);
	BlueImage = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);
	}else{
	grey = new int[newwidth][newheight][states];
	GreyImage = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_BYTE_GRAY);
	}
	image = new int[newwidth][newheight];
	count = new int[newwidth][newheight];
	}catch(java.lang.OutOfMemoryError e) { status.setText("Not enough memory"); return;}
	
	
System.out.println(name);
for(int i = 0; i<filtersize;i++){
	for(int j = 0; j<filtersize; j++){
		if(i==1&&j==1){matrix[i][j] = 18;}
		else{matrix[i][j] = -2;}		
	}
}
 for(int h = 0; h<newheight; h++){
	  for(int w = 0; w<newwidth; w++){
		  image[w][h] = originalImage.getRGB((int) Math.floor(w/size), (int) Math.floor(h/size));
		  Color color = new Color(image[w][h]);
		  if(Is_Color){
			  red[w][h][state] = color.getRed();
			  green[w][h][state] = color.getGreen();
			  blue[w][h][state] = color.getBlue();
			  ared +=  red[w][h][state];
			  agreen += green[w][h][state];
			  ablue += blue[w][h][state]; 
			  numred[color.getRed()]++;
			  numgreen[color.getGreen()]++;
			  numblue[color.getBlue()]++;
		  }else{
			  grey[w][h][state] = (int)(((color.getRed()*0.21) + (color.getGreen()*0.71) + (color.getBlue()*0.07)));
			  agrey +=grey[w][h][state];
			  numgrey[grey[w][h][state]]++;
			 
		  }
		 
	  	}
	  }
 if(Is_Color){
  ared = ared/(newheight*newwidth);
  agreen = agreen/(newheight*newwidth);
  ablue = ablue/(newheight*newwidth);
  for(int i = 0; i<256; i++){
	  if(numred[i]  >numred[ired]   ){ired = i;}
	  if(numblue[i] >numblue[iblue] ){iblue = i;}
	  if(numgreen[i]>numblue[igreen]){igreen = i;}
  }
 } else{
  agrey = agrey/(newheight*newwidth);
  for(int i=0; i<256; i++){
	  if(numgrey[i]>numgrey[igrey]){ igrey = i;}  
  }
 }
 
  
  state++;
   System.out.println("Loaded image and filter matrix");	
      
   if(rotate && angle!=0){

   for(int h=0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			  
			  double l = Math.sqrt(Math.pow(w-midw, 2) + Math.pow(h-midh, 2));
			  double theta = Math.atan2(h-midh, w-midw);
			  if(theta<0){
				  theta = theta + Math.PI*2;
			  }
			  double newh = l*Math.sin(theta-((angle*Math.PI)/180)) + midh;
			  double neww = l*Math.cos(theta-((angle*Math.PI)/180)) + midw;
			  int nw = (int) neww;
			  int nh = (int) newh;
			  if(nw>=0 && nw<newwidth && nh>=0 && nh<newheight){
				  if(Is_Color){
					  r = red[nw][nh][state-1];
					  g = green[nw][nh][state-1];
					  b = blue[nw][nh][state-1];
			   
					  red[w][h][state] = Math.min(Math.max(0, r), 255);
					  green[w][h][state] = Math.min(Math.max(0, g),255);
					  blue[w][h][state] = Math.min(Math.max(0, b),255);
				  }
			  else{
					a = grey[nw][nh][state-1];
					grey[w][h][state] =  Math.min(Math.max(0, a),255);
				  }
				 
			  }
			 else{
				if(Is_Color){
				  red[w][h][state] = red[Math.abs(Math.abs(nw-newwidth) - newwidth)-1][Math.abs(Math.abs(nh-newheight) - newheight)-1][state-1];
				  green[w][h][state] = green[Math.abs(Math.abs(nw-newwidth) - newwidth)-1][Math.abs(Math.abs(nh-newheight) - newheight)-1][state-1];
				  blue[w][h][state] = blue[Math.abs(Math.abs(nw-newwidth) - newwidth)-1][Math.abs(Math.abs(nh-newheight) - newheight)-1][state-1];
				}
				else{  grey[w][h][state] = grey[Math.abs(Math.abs(nw-newwidth) - newwidth)-1][Math.abs(Math.abs(nh-newheight) - newheight)-1][state-1];}
			  
				}
		   }
		  
		  }
   
	  state++;
	  System.out.println("Rotated image");
   }
   
   
   if(use_filter){
	   
	  for(int h=0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			  if(Is_Color){
			  red[w][h][state] = 0;
			  green[w][h][state] = 0;
			  blue[w][h][state] = 0;
			  }
			  else{
			  grey[w][h][state] = 0;
			  }
			  count[w][h] = 0;
			  for(int i=0; i<filtersize;i++){
				  for(int j=0; j<filtersize;j++){
					  try{
						if(Is_Color){  
							red[w][h][state] +=  matrix[i][j]*red[w + i - ((filtersize-1)/2)][h + j - ((filtersize-1)/2)][state-1];
							green[w][h][state] += matrix[i][j]*green[w + i - ((filtersize-1)/2)][h + j - ((filtersize-1)/2)][state-1];
							blue[w][h][state] += matrix[i][j]*blue[w + i - ((filtersize-1)/2)][h + j - ((filtersize-1)/2)][state-1];
						} 
						else{
							
							grey[w][h][state] += matrix[i][j]*grey[w + i - ((filtersize-1)/2)][h + j - ((filtersize-1)/2)][state-1];
							
						}
						count[w][h] += matrix[i][j];
					  } 
					  catch (Exception e) {}
				  }
			  }
			  if(count[w][h]==0){count[w][h] = 1;}
			  if(Is_Color){
			  red[w][h][state] = (int) red[w][h][state]/count[w][h];
			  green[w][h][state] = (int) green[w][h][state]/count[w][h];
			  blue[w][h][state] = (int) blue[w][h][state]/count[w][h];
			  } else{ grey[w][h][state] = (int) grey[w][h][state]/count[w][h];}
		     }
		  }
	  state++;
	  System.out.println("Applied filter matrix");
   }
	  
	  
	  
	  if(contrast!=1){
	  for(int h=0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			  if(Is_Color){
			   r = red[w][h][state-1];
			   g = green[w][h][state-1];
			   b = blue[w][h][state-1];
			   
			  r = (int) (((r-ared)*contrast) + ared);
			  g = (int) (((g-agreen)*contrast) + agreen);
			  b = (int) (((b-ablue)*contrast) + ablue);
			  red[w][h][state] = Math.min(Math.max(0, r), 255);
			  green[w][h][state] = Math.min(Math.max(0, g),255);
			  blue[w][h][state] = Math.min(Math.max(0, b),255);
			  }
			  else{
				a = grey[w][h][state-1];
				a = (int) (((a-agrey)*contrast) + agrey);
				grey[w][h][state] =  Math.min(Math.max(0, a),255);
				
			  }
		   }
		 
		  }
	  state++;
	  System.out.println("Applied contrast");
	  }
	 
	if(do_thresh){
	  for(int h=0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			
			 
			 
			  if(Is_Color){
				   r = red[w][h][state-1];
				   g = green[w][h][state-1];
				   b = blue[w][h][state-1];
				  if(!auto_threshold){ 
					   ired = threshold.getRed();
					   igreen = threshold.getGreen();
					   iblue = threshold.getBlue();
				     }
			      if(r> ired+ tolerance){r = 255;}
				  if(g> igreen + tolerance){g = 255;}
				  if(b> iblue + tolerance){b = 255;}
				  if(r< ired - tolerance){r = 0;}
				  if(g< igreen- tolerance){g = 0;}
				  if(b< iblue - tolerance){b = 0;}
			  
				  red[w][h][state] = Math.min(Math.max(0, r), 255);
				  green[w][h][state] = Math.min(Math.max(0, g),255);
				  blue[w][h][state] = Math.min(Math.max(0, b),255);
				  }
			  else{
				  a = grey[w][h][state-1];
				  	if(!auto_threshold){
				  		igrey = (int) (threshold.getRed()*0.21 + threshold.getGreen()*0.71 + threshold.getBlue()*0.07);
				  	}
				  if(a>igrey + tolerance){a = 255;}
				  if(a<igrey - tolerance){a = 0;}
				  grey[w][h][state] = Math.min(Math.max(0,a),255);
			  }
			  
		     }
		  }
	  state++;
	  System.out.println("Applied thresholding");
	}
	if(do_thresh2){
	 for(int h = 0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			  image[w][h] = originalImage.getRGB((int) Math.floor(w/size), (int) Math.floor(h/size));
			  Color color = new Color(image[w][h]);
			  if(Is_Color){
				  red[w][h][state] = color.getRed();
				  green[w][h][state] = color.getGreen();
				  blue[w][h][state] = color.getBlue();
				  ared +=  red[w][h][state];
				  agreen += green[w][h][state];
				  ablue += blue[w][h][state]; 
				  numred[color.getRed()]++;
				  numgreen[color.getGreen()]++;
				  numblue[color.getBlue()]++;
			  }else{
				  grey[w][h][state] = (int)(((color.getRed()*0.21) + (color.getGreen()*0.71) + (color.getBlue()*0.07)));
				  agrey +=grey[w][h][state];
				  numgrey[grey[w][h][state]]++;
				 
			  }
			 
		  	}
		  }
	 if(Is_Color){
	  ared = ared/(newheight*newwidth);
	  agreen = agreen/(newheight*newwidth);
	  ablue = ablue/(newheight*newwidth);
	  for(int i = 0; i<256; i++){
		  if(numred[i]  >numred[ired]   ){ired = i;}
		  if(numblue[i] >numblue[iblue] ){iblue = i;}
		  if(numgreen[i]>numblue[igreen]){igreen = i;}
	  }
	 } else{
	  agrey = agrey/(newheight*newwidth);
	  for(int i=0; i<256; i++){
		  if(numgrey[i]>numgrey[igrey]){ igrey = i;}  
	  }
	 }
	
	
	 for(int h=0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			 
			  
			 
			  if(Is_Color){
				  r = red[w][h][state-1];
				   g = green[w][h][state-1];
				   b = blue[w][h][state-1];
				  if(!auto_threshold2){ 
					   ired = threshold2.getRed();
					   igreen = threshold2.getGreen();
					   iblue = threshold2.getBlue();
				     }
			      if(r> ired+ tolerance2){r = 255;}
				  if(g> igreen + tolerance2){g = 255;}
				  if(b> iblue + tolerance2){b = 255;}
				  if(r< ired - tolerance2){r = 0;}
				  if(g< igreen- tolerance2){g = 0;}
				  if(b< iblue - tolerance2){b = 0;}
			  
				  red[w][h][state] = Math.min(Math.max(0, r), 255);
				  green[w][h][state] = Math.min(Math.max(0, g),255);
				  blue[w][h][state] = Math.min(Math.max(0, b),255);
				  }
			  else{
				  a = grey[w][h][state-1];
				  
				  	if(!auto_threshold2){
				  		igrey = (int) (threshold2.getRed()*0.21 + threshold2.getGreen()*0.71 + threshold2.getBlue()*0.07);
				  	}
				  if(a>igrey + tolerance2){a = 255;}
				  if(a<igrey - tolerance2){a = 0;}
				  grey[w][h][state] = Math.min(Math.max(0,a),255);
			  }
			  
		     }
		  }
	  state++;
	  System.out.println("Applied 2nd threshold ");
	}
		try {
			
			FileWriter fWriter = new FileWriter(path + "/array/" + name + state +".txt");
			BufferedWriter writer = new BufferedWriter(fWriter);
			 state--;
	  for(int h=0; h<newheight; h++){
		  for(int w = 0; w<newwidth; w++){
			  if(Is_Color==true){
			   r = red[w][h][state];
			   g = green[w][h][state];
			   b = blue[w][h][state];
			  red[w][h][state] = Math.min(Math.max(0, r), 255);
			  green[w][h][state] = Math.min(Math.max(0, g),255);
			  blue[w][h][state] = Math.min(Math.max(0, b),255);
			  Color newcolor = new Color(red[w][h][state], green[w][h][state], blue[w][h][state]);
			  writer.write(String.format("%03d", red[w][h][state])+ " " + String.format("%03d", green[w][h][state]) +" "+String.format("%03d", blue[w][h][state]) + "  ,  " );
			  Color redcolor = new Color(newcolor.getRed(),0,0);
			  Color greencolor = new Color(0,newcolor.getGreen(),0);
			  Color bluecolor = new Color(0,0,newcolor.getBlue());
			  RedImage.setRGB(w, h, redcolor.getRGB());
			  GreenImage.setRGB(w, h, greencolor.getRGB());
			  BlueImage.setRGB(w, h, bluecolor.getRGB());
			  
			  Image.setRGB(w, h, newcolor.getRGB());
			  }
			  else{
				  a = grey[w][h][state];
				  grey[w][h][state] = Math.min(Math.max(0,a),255);
				  Color newcolor = new Color(grey[w][h][state], grey[w][h][state], grey[w][h][state]);
				  
				  writer.write(String.format("%03d", grey[w][h][state]) + " " );
				 GreyImage.setRGB(w, h, newcolor.getRGB());
			  }
			  
			  
		  }
		  writer.newLine();
	  }

	   writer.close();
	} catch (Exception e) { 
		e.printStackTrace();
	}
		state++;
		if(Is_Color){
ImageIO.write(Image, "png", new File(path + "/processed",name + state + ".png"));
ImageIO.write(RedImage, "png", new File(path + "/processed",name + "(Red) (" + state + ").png"));
ImageIO.write(BlueImage, "png", new File(path + "/processed",name + "(Blue) (" + state + ").png"));
ImageIO.write(GreenImage, "png", new File(path + "/processed",name + "(Green) (" + state + ").png"));
}
		else{
			ImageIO.write(GreyImage, "png", new File(path + "/processed",name + state + ".png"));
			
		}
 System.out.println("Written image data in text file and drawn image");
 File file =  new File(path + "/output/" + name + state + ".txt");
 file.delete();
    String command = "c:/Windows/System32/cmd.exe";
    Runtime.getRuntime().exec(command);
    Runtime.getRuntime().exec("tesseract " + path + "/processed/"+ name + state + ".png " + path + "/output/" + name + state);
    boolean opened = false;
    BufferedReader bufferedReader;
    while(!opened){
    try{
    FileReader fileReader =  new FileReader(path + "/output/" + name + state + ".txt");
    bufferedReader =  new BufferedReader(fileReader);
    opened = true;
    String line;
    char chr[] = {'!', '@', '#', '%', '^', '&', '*', '|', '_', '/', '�', '�', '�', '�', '�'};
	while((line = bufferedReader.readLine()) != null) {
		if(remove_glyphs){
			for(int i = 0; i<line.length(); i++){
				for(int j = 0; j<chr.length; j++){
					if(line.charAt(i)==chr[j]){
						if(i==0){line = " " + line.substring(i+1);}
						else{line = line.substring(0, i) + " " +line.substring(i+1);}
				}
			}
		}
		}
        OCR_text.setText(OCR_text.getText() + line + " ");
    }	
    bufferedReader.close();
    
    
    
    }catch(Exception e){
    	opened = false;
    	System.out.print(".");
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
    }
    System.out.println("");
    System.out.println("Text recognised");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    BufferedImage oldimg = ImageIO.read(new File(path + "/raw/" + fullname));
    BufferedImage newimg=ImageIO.read(new File(path + "/processed/" + name + state + ".png"));
    double imgwidth = ui.getWidth() * perwidth/2;
    ImageIcon oldicon=new ImageIcon(oldimg.getScaledInstance((int) imgwidth, (int) (ui.getHeight()*perheight),java.awt.Image.SCALE_SMOOTH));
	ImageIcon newicon=new ImageIcon(newimg.getScaledInstance((int) imgwidth, (int) (ui.getHeight()*perheight),java.awt.Image.SCALE_SMOOTH));
	 oldimage.setIcon(oldicon);
	 newimage.setIcon(newicon);	 
    OCR_text.setText(OCR_text.getText());
    text.setVisible(true);
    status.setText("  Done");
}
}	