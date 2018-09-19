/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jinputjoysticktestv2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RobotConnection implements Runnable
{
    Socket requestSocket;
    InputStream in;
    OutputStream out;
    byte[] request;
    byte[] response;
    byte[] buff;
    JoystickTest gui;
    String IP;
    int port;
    //InputStreamReader input;
    //OutputStream output;
    FileOutputStream file;
    PrintWriter writeFile;
    String message;
    short timestamp;  
    public RobotConnection(JoystickTest guiObject)
    {
       request = new byte[9];
       response = new byte[30];
       buff = new byte[4];
       gui = guiObject;
       timestamp = 0;
       //IP = "31.30.3.173";
       IP = JoystickTest.robotIP;
       port = JoystickTest.port;
       
    }
    public void setIP()
    {
        IP = JoystickTest.robotIP;
        port = JoystickTest.port;  
    }

    @Override
    public void run()
    {
        try{
                        file = new FileOutputStream("AngleLeftRightVelocityLog.txt",true);
                        writeFile = new PrintWriter(file);
			byte[] temp = new byte[4];
			requestSocket = new Socket(/*"localhost"*//*"31.30.3.173"*/IP, port);
			System.out.println("Connected to 31.30.4.173 at port 8888");
			//2. get Input and Output streams
			out = requestSocket.getOutputStream();
			//out.flush();
			in = requestSocket.getInputStream();
                        
                        while(true)
                        {
                            ByteBuffer b = ByteBuffer.allocate(2);
                            b.putShort(new Double(gui.velocity).shortValue());
                            byte[] result = b.array();
                            request[0] = result[0];
                            request[1] = result[1];
                            System.out.println(new Double(gui.velocity).shortValue());
                            b = ByteBuffer.allocate(2);
                            b.putShort(new Double(gui.steerAngle*65535/180).shortValue());
                            result = b.array();
                            request[2] = result[0];
                            request[3] = result[1];
                            
                            b = ByteBuffer.allocate(2);
                            b.putShort(new Integer(gui.pHeight).shortValue());
                            result = b.array();
                            request[4] = result[0];
                            request[5] = result[1];
                            if(gui.light1==true)
                            {
                                if(gui.light2==true)
                                    request[6]=0x03;
                                else
                                    request[6]=0x01;                                            
                            }  
                            else
                            {
                                if(gui.light2==true)
                                    request[6]=0x02;
                                else
                                    request[6]=0x00;
                            }
                            b = ByteBuffer.allocate(2);
                            b.putShort(timestamp);
                            result = b.array();
                            request[7] = result[0];
                            request[8] = result[1];
                            
                            out.write(request);
                            System.out.println("Bytes Sent ");
                            //System.out.println("First Byte Sent: "+request[0]);
                            for(int i=0;i<9;i++)
                                System.out.print(String.format("%02X ",request[i]).toString());
                            System.out.println(" ");
                            int read = in.read(response);
                            System.out.println("Bytes read : " + read);
                            temp[3] = response[12];
                            temp[2] = response[13];
                            temp[1] = response[14];
                            temp[0] = response[15];
                            ByteBuffer buffer = ByteBuffer.allocate(4);
                            buffer.put(temp);
                            gui.leftMtrVel = -buffer.getInt(0);
                            
                            temp[3] = response[16];
                            temp[2] = response[17];
                            temp[1] = response[18];
                            temp[0] = response[19];
                            buffer = ByteBuffer.allocate(4);
                            buffer.put(temp);
                            gui.rightMtrVel = buffer.getInt(0);
                            
                            temp[3] = response[20];
                            temp[2] = response[21];
                            temp[1] = response[22];
                            temp[0] = response[23];
                            buffer = ByteBuffer.allocate(4);
                            buffer.put(temp);
                            gui.actualVehicleSteerAngle = buffer.getInt(0);
                            
                            byte[] temp2 = new byte[2];
                            temp2[1] = response[24];
                            temp2[0] = response[25];
                            ByteBuffer buffer2 = ByteBuffer.allocate(2);
                            buffer2.put(temp2);
                            gui.actualPlatHeight = buffer2.getShort(0);
                      
                            byte[] temp3 = new byte[2];
                            temp3[1] = response[26];
                            temp3[0] = response[27];
                            buffer2 = ByteBuffer.allocate(2);
                            buffer2.put(temp3);
                            gui.voltageValue = (float)(buffer2.getShort(0)/100.0);
                            
                            writeFile.println(gui.actualVehicleSteerAngle+"\t"+gui.leftMtrVel+"\t"+gui.rightMtrVel);
                            Thread.sleep(50);
                        }
                        
			
		}
		catch(UnknownHostException unknownHost){
                    
			System.err.println("You are trying to connect to an unknown host!");
                        JOptionPane.showMessageDialog(null, "Connection Could not established...Please check IP Address", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
		}
		catch(IOException ioException){
			ioException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Connection Error...No Network Connection", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
		}
                catch(Exception e)
                {
                    System.err.println("Some error occured \n"+e);
                    JOptionPane.showMessageDialog(null, "Please Check Robot Connection...", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
		finally{
			//4: Closing connection
			try{                               
				writeFile.close();
				requestSocket.close();
                                return;
			}
			catch(IOException ioException){
				ioException.printStackTrace();
                                return;
			}
                        catch(Exception e){ return;}
		}
    }
}
