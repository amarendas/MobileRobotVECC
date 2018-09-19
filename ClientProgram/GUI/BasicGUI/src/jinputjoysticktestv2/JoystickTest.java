/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jinputjoysticktestv2;
import com.sun.jna.NativeLibrary;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
/**
 * @author NNR
 *
 */

public class JoystickTest 
{
    //private static EmbeddedMediaPlayerComponent ourMediaPlayer;
    public static EmbeddedMediaPlayerComponent ourMediaPlayer;
    static String url="";
    String vlcPath="";
    static String mediaPath = "";
    static JFrameWindow window;
    private ArrayList<Controller> foundControllers;
    public static Thread Robot;
    public static RobotConnection robotConn;
    double velocity;
    double steerAngle;
    public int pHeight;
    int actualPlatHeight;
    public int actualVehicleSteerAngle;
    boolean light1;
    boolean light2;
    boolean reverseGear;
    int vConstant;
    double aConstant;
    public int leftMtrVel;
    public int rightMtrVel;
    public float voltageValue;
    boolean stopBit;
    public static String robotIP;
    public static int port;
    public static JoystickTest guiObject;
    public int maxVelocity;
    public int platformHeightConstant;
    public static void main(String args[]) 
    {
       // JInputJoystickTest jinputJoystickTest = new JInputJoystickTest();
       // Writes (into console) informations of all controllers that are found.
       // jinputJoystickTest.getAllControllersInfo();
       // In loop writes (into console) all joystick components and its current values.
       //jinputJoystickTest.pollControllerAndItsComponents(Controller.Type.STICK);
       //jinputJoystickTest.pollControllerAndItsComponents(Controller.Type.GAMEPAD);
       // NativeLibrary.addSearchPath("libvlc", "E:/shishir/VECC Robot/GUI/BasicGUI/VLC");
       // System.setProperty("jna.library.path", "E:/shishir/VECC Robot/GUI/BasicGUI/VLC");
      
        JoystickTest.guiObject=new JoystickTest();
        
    } 
    
    public JoystickTest() 
    {
        robotIP = "31.30.4.173"/*"192.168.43.133*/;
        port = 8888;
        vConstant = 5; //velocity constant for 2=200 so 1=100
        aConstant = 1.8;
        pHeight = 0;
        actualPlatHeight = 0;
        leftMtrVel = 0;
        rightMtrVel = 0;
        actualVehicleSteerAngle = 0;
        voltageValue = (float)0.0;
        reverseGear = false;
        maxVelocity = 500;
        platformHeightConstant = 352;
        stopBit = false;
        window = new JFrameWindow();
        robotConn = new RobotConnection(this);
        foundControllers = new ArrayList<>();
        searchForControllers();
       
        // If at least one controller was found we start showing controller data on window.
        if(!foundControllers.isEmpty())
            startShowingControllerData();
        else
            window.addControllerName("No controller found!");
    }
  

    /**
     * Search (and save) for controllers of type Controller.Type.STICK,
     * Controller.Type.GAMEPAD, Controller.Type.WHEEL and Controller.Type.FINGERSTICK.
     */
   private void searchForControllers() 
   {
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for(int i = 0; i < controllers.length; i++)
        {
            Controller controller = controllers[i];
            if (controller.getType() == Controller.Type.STICK || 
                controller.getType() == Controller.Type.GAMEPAD || 
                controller.getType() == Controller.Type.WHEEL ||
                controller.getType() == Controller.Type.FINGERSTICK)
            {
                // Add new controller to the list of all controllers.
                foundControllers.add(controller);
                
                // Add new controller to the list on the window.
                window.addControllerName(controller.getName() + " - " + controller.getType().toString() + " type");
            }
        }
    }
    
    /**
     * Starts showing controller data on the window.
     */
    private void startShowingControllerData()
     {
         //for testing commented
       //Robot = new Thread(new RobotConnection(this));
       //Robot.start();
         ///////////////
       //Camera URL
       //url="rtsp://31.30.3.55/axis-media/media.3gp";
       url="http://admin:drhr@31.30.4.174/video.cgi";
       File ourFile1;
       //Path to the VLC Directory. Use VLC Media Player version 2.0.1
       ourFile1 = new File("C:/Program Files/VideoLAN/VLC");
       //ourFile1 = new File("D:/shishir/GUI/BasicGUI/VLC");
       //ourFile1 = new File("E:/shishir/VECC Robot/GUI/BasicGUI/VLC");
       vlcPath = ourFile1.getAbsolutePath();
       MediaPanel(vlcPath,url);
       while(true)
        {
            if(!JoystickTest.window.controllerFrame.isShowing())
            {
                 JoystickTest.window.controllerFrame.enableButton.setSelected(false);
                 JoystickTest.window.controllerFrame.disablingComponents();
            }
            // Currently selected controller.
            int selectedControllerIndex = window.getSelectedControllerName();
            Controller controller = foundControllers.get(selectedControllerIndex);
            // Pull controller for current data, and break while loop if controller is disconnected.
            if( !controller.poll())
            {
                window.showControllerDisconnected();
                break;
            }
            JoystickTest.window.LeftMtrRPM.setText(""+leftMtrVel);
            JoystickTest.window.RightMtrRPM.setText(""+rightMtrVel);
            JoystickTest.window.voltageLevelLabel.setText(voltageValue+"V");
            // X axis and Y axis
            double xAxisPercentage = 0;
            double yAxisPercentage = 0;
            
            // JPanel for progress bars
            JPanel axesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 2));
            axesPanel.setBounds(0, 0, 200, 190);
            
            // JPanel for controller buttons
            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1));
            buttonsPanel.setBounds(6, 19, 246, 110);
             
            // Go trough all components of the controller.
            Component[] components = controller.getComponents();
            for(int i=0; i < components.length; i++)
            {
                Component component = components[i];
                Identifier componentIdentifier  = component.getIdentifier();
                
                // Buttons
                //if(component.getName().contains("Button")){ // If the language is not english, this won't work.
                if(componentIdentifier.getName().matches("^[0-9]*$"))
                { // If the component identifier name contains only numbers, then this is a button.
                    // Is button pressed?
                    boolean isItPressed = true;
                    if(component.getPollData() == 0.0f)
                        isItPressed = false;
//                     System.out.println("button value: "+component.getPollData()+"\n");
                    // Button index
                    String buttonIndex;
                    buttonIndex = component.getIdentifier().toString();
                    //System.out.println("button value: "+buttonIndex+"\n");
                    // Create and add new button to panel.
                    if(JoystickTest.window.controllerFrame.isShowing()&&JoystickTest.window.controllerFrame.enableButton.isSelected())
                    {
                       light1 = JoystickTest.window.controllerFrame.leftLamp.isSelected();
                       light2 = JoystickTest.window.controllerFrame.rightLamp.isSelected();
                    }
                    else
                    {
                        if(Integer.parseInt(buttonIndex)==0&&isItPressed==true)
                        {
                            if(light1==true)
                                light1=false;
                            else
                                light1=true;                                    
                        }
                        if(Integer.parseInt(buttonIndex)==1&&isItPressed==true)
                        {
                            if(light2==true)
                                light2=false;
                            else
                                light2=true;                                    
                        }
                        
                    }
                    if(Integer.parseInt(buttonIndex)==2&&isItPressed==true)
                    {
                        // if(reverseGear==true)
                        // {
                        //    reverseGear=false;
                         //   JoystickTest.window.reverseDpl.setText("False");
                            //JoystickTest.window.reverseDpl.setBackground(Color.BLACK);
                         //   JoystickTest.window.reverseDpl.setForeground(Color.BLACK);
                        // }
                        // else
                        // {
                            reverseGear=true;
                            JoystickTest.window.reverseDpl.setText("True");
                            //JoystickTest.window.reverseDpl.setBackground(Color.red);
                            JoystickTest.window.reverseDpl.setForeground(Color.red);
                        // }
                    }
                    if(Integer.parseInt(buttonIndex)==2&&isItPressed==false)
                    {
                        reverseGear=false;
                            JoystickTest.window.reverseDpl.setText("False");
                           // JoystickTest.window.reverseDpl.setBackground(Color.BLACK);
                            JoystickTest.window.reverseDpl.setForeground(Color.BLACK);
                    }
                    //System.out.println("light 1 value: "+light1+"  light 2 value: "+light2+"\n");
                    Integer buttonInt = new Integer(Integer.parseInt(buttonIndex)+1);
                    String buttonIndex2 = buttonInt.toString();
                    JToggleButton aToggleButton = new JToggleButton(buttonIndex2, isItPressed);
                    aToggleButton.setPreferredSize(new Dimension(48, 25));
                    aToggleButton.setEnabled(false);
                    if(Integer.parseInt(buttonIndex)==0||Integer.parseInt(buttonIndex)==1||Integer.parseInt(buttonIndex)==2)
                    {
                        buttonsPanel.add(aToggleButton);
                    }
                    
                    // We know that this component was button so we can skip to next component.
                    continue;
                }
                
                // Hat switch
                if(componentIdentifier == Component.Identifier.Axis.POV)
                {
                    float hatSwitchPosition = component.getPollData();
                    //System.out.println("switch position: "+hatSwitchPosition+"\n");
                    window.setHatSwitch(hatSwitchPosition);
                    if(JoystickTest.window.controllerFrame.isShowing()&&JoystickTest.window.controllerFrame.enableButton.isSelected())
                    {
                            //JOptionPane.showMessageDialog(null, "Robot is not connected", "Error", JOptionPane.ERROR_MESSAGE);
                        pHeight = JoystickTest.window.controllerFrame.zAxisSlider.getValue();
                    }
                    else
                    {
                        if(hatSwitchPosition==0.25)
                        {
                            pHeight = pHeight+1;
                        }
                        if(hatSwitchPosition==0.75)
                        {
                            pHeight = pHeight-1;
                            if(pHeight<=platformHeightConstant)
                                pHeight=platformHeightConstant;
                        }
                    }
                    if(pHeight>1800)
                        pHeight = 1800;
                    JoystickTest.window.zAxisDpl.setText(""+(int)pHeight);
                    //if(JoystickTest.window.controllerFrame.isShowing())
                    //{
                        //JOptionPane.showMessageDialog(null, "Robot is not connected", "Error", JOptionPane.ERROR_MESSAGE);
                    //}
                    //System.out.println("Platform height position: "+pHeight+"\n");
                    // We know that this component was hat switch so we can skip to next component.
                    continue;
                }
                
                //Creates the arc 
                window.arc();
                if(component.isAnalog())
                {
                    double axisValue = component.getPollData();
                    double axisValueInPercentage = getAxisValueInPercentage(axisValue);
                    
                    // X Component
                    if(componentIdentifier == Component.Identifier.Axis.X)
                    {
                        //System.out.println("Axis percentage value "+axisValueInPercentage);
                        //Calculates steering wheel parameters
                        xAxisPercentage = axisValueInPercentage;
                        double angle = 1.8*xAxisPercentage;
                        window.line(angle);
                        if(JoystickTest.window.controllerFrame.isShowing()&&JoystickTest.window.controllerFrame.enableButton.isSelected())
                        {
                            //JOptionPane.showMessageDialog(null, "Robot is not connected", "Error", JOptionPane.ERROR_MESSAGE);
                            steerAngle = JoystickTest.window.controllerFrame.angleSlider.getValue();
                        }
                        else
                        {
                            steerAngle = -1.8*(xAxisPercentage-50);
                        }
                        JoystickTest.window.angleDpl.setText(""+String.format("%.2f",steerAngle));
                        continue; // Go to next component.
                    }
                    // Y Component
                    if(componentIdentifier == Component.Identifier.Axis.Y)
                    {
                        yAxisPercentage = axisValueInPercentage;
                        //System.out.println("Axis percentage value "+axisValueInPercentage);
                   // JLabel progressBarLabel = new JLabel(component.getName());
                        JProgressBar progressBar1 = new JProgressBar(0, 50);
                        JProgressBar progressBar2 = new JProgressBar(51, 100);
                        progressBar1.setOrientation(SwingConstants.VERTICAL);
                        progressBar2.setOrientation(SwingConstants.VERTICAL);
                        int aVIP = (int) axisValueInPercentage;
                        axesPanel.add(progressBar1);
                        axesPanel.add(progressBar2);
                        progressBar1.setValue(50-aVIP);
                        progressBar2.setValue(aVIP);
                        double temp = 2*(49.6086061000824 - yAxisPercentage);
                        if(JoystickTest.window.controllerFrame.isShowing()&&JoystickTest.window.controllerFrame.enableButton.isSelected())
                        {
                            boolean reverse = false;
                            //JOptionPane.showMessageDialog(null, "Robot is not connected", "Error", JOptionPane.ERROR_MESSAGE);
                            velocity = JoystickTest.window.controllerFrame.velocitySlider.getValue();
                            reverse = JoystickTest.window.controllerFrame.reverse.isSelected();
                            if(reverse==true)
                            {
                                velocity = -velocity;
                                if(velocity<-maxVelocity)
                                {
                                    velocity = -maxVelocity;
                                }
                            }
                            if(pHeight>platformHeightConstant)
                            {
                                velocity = 0;
                            }
                            
                        }
                        else
                        {
                            if(temp>=0)
                            {
                                velocity = vConstant*temp;
                            }
                            else
                            {
                                velocity = 0;
                            }
                            if(pHeight>platformHeightConstant)
                            {
                                velocity = 0;
                            }
                            if(reverseGear==true)
                            {
                                velocity = -velocity;
                                if(velocity<-maxVelocity)
                                {
                                    velocity = -maxVelocity;
                                }
                            }
                        }
                        
                        JoystickTest.window.velDpl.setText(""+(int)velocity);
                        continue; // Go to next component.
                   }
   
                    // Other axis
                   /* JLabel progressBarLabel = new JLabel(component.getName());
                    JProgressBar progressBar = new JProgressBar(0, 100);
                    progressBar.setValue(axisValueInPercentage);
                    axesPanel.add(progressBarLabel);
                    axesPanel.add(progressBar); */
                }
            }
            
            // Now that we go trough all controller components,
            // we add butons panel to window,
            window.setControllerButtons(buttonsPanel);
            // set x and y axes,
            window.setXYAxis(xAxisPercentage , yAxisPercentage);
            // add progress bar panel to window.
            window.addAxisPanel(axesPanel);
            
           // if(!JoystickTest.Robot.isAlive())
           // {
                //for testing commented
                //JOptionPane.showMessageDialog(null, "Robot is not connected", "Error", JOptionPane.ERROR_MESSAGE);
           // }
            JoystickTest.window.controllerFrame.actualZaxisValue.setText(""+(int)actualPlatHeight);
            JoystickTest.window.zAxisDplActual.setText("Actual height: "+(int)actualPlatHeight);
            JoystickTest.window.voltageLevelLabel.setText(voltageValue+" V");
        }
    }
    
    /*
     * Starts showing camera feed on the window
     */
    public static void MediaPanel(String vlcPath, String mediaURL) 
    {
        //JPanel for camera feed 
        JPanel mediaPanel = new JPanel();
        //mediaPanel.setBounds(6,19,493,278);
        mediaPanel.setBounds(6,14,520,320);
        mediaPath = mediaURL;
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),vlcPath);
        //Creates a new Media Player
        ourMediaPlayer = new EmbeddedMediaPlayerComponent();
        mediaPanel.setLayout(new BorderLayout());
        mediaPanel.add(ourMediaPlayer, BorderLayout.CENTER); 
        //Add Camera stream panel to window
        window.camera(mediaPanel);
        //Sets the camera stream options
        String[] options = {
                ":file-caching=0",
                ":network-caching=50",
                ":sout = #transcode{vcodec=x264,vb=800,scale=0.25,acodec=none,fps=15}:display :no-sout-rtp-sap :no-sout-standard-sap :ttl=1 :sout-keep"};
        ourMediaPlayer.getMediaPlayer().playMedia(mediaPath,options);
        //:sout = #transcode{vcodec=x264,vb=800,scale=0.25,acodec=none,fps=23}:display :no-sout-rtp-sap :no-sout-standard-sap :ttl=1 :sout-keep"
    }
    
      // We have to give processor some rest.
            /*try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(JoystickTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } */

    /**
     * Given value of axis in percentage.
     * Percentages increases from left/top to right/bottom.
     * If idle (in center) returns 50, if joystick axis is pushed to the left/top 
     * edge returns 0 and if it's pushed to the right/bottom returns 100.
     * 
     * @return value of axis in percentage.
     */
    public double getAxisValueInPercentage(double axisValue)
    {
        return (double)(((2 - (1 - axisValue)) * 100) / 2);
    } 
}