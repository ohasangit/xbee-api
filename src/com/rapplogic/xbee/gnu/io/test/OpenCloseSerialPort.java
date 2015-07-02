package gnu.io.test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import com.rapplogic.xbee.api.XBeeException;

import gnu.io.*;


public class OpenCloseSerialPort {

	public static void main(String[] args) {
		RXTXPort serialPort = null;
		String port = "/dev/tty.usbserial-A603HADO";
		
		// Apparently you can't query for a specific port, but instead must iterate
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
				
		CommPortIdentifier portId = null;
				
		while (portList.hasMoreElements()) {

			portId = portList.nextElement();

			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

				if (portId.getName().equals(port)) {
					//log.debug("Using Port: " + portId.getName());
					break;
				}
			}
		}
				
		try {
			serialPort = (RXTXPort) portId.open("Fucking shit", 0);
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
//		try {
//			serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//		} catch (UnsupportedCommOperationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
//		} catch (UnsupportedCommOperationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// activate the DATA_AVAILABLE notifier
//		serialPort.notifyOnDataAvailable(true);
				
		// activate the OUTPUT_BUFFER_EMPTY notifier
		//serialPort.notifyOnOutputEmpty(true);
				
		//serialPort.addEventListener(this);
				
//		try {
//			InputStream inputStream = serialPort.getInputStream();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			BufferedOutputStream outputStream = new BufferedOutputStream(serialPort.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			serialPort.getInputStream().close();
//		} catch (Exception e) {
//		}
//		
//		try {
//			serialPort.getOutputStream().close();
//		} catch (Exception e) {
//		}
		
		System.out.println("Closing Serial Port");
		
		//serialPort.IOLocked = 0;
		serialPort.close();
		
	}

}
