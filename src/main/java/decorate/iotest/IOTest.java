package decorate.iotest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PushbackInputStream;

//IO包下的各个类与装饰模式有不接之缘，我们详细了解一下
public class IOTest {

	public static void main(String[] args) throws IOException {
		final String path = "F://text.txt";
		/*
		  InputStream相当于被装饰的接口或者是抽象类，FileInputStream相当于待装饰的原始对象
		  FileInputStream是以只读形式打开一个文件，并打开了一个文件的句柄存放在FileDescriptor对象的handle属性
		  FileInputStream没有重写InputStream的mark和reset方法
		    以下有关回退和重新标记等操作，都是在堆中建立缓冲区所造成的假象，并不是真正的文件流回退和标记
		*/
		InputStream inputStream = new FileInputStream(path);
		//流的长度
		final int length = inputStream.available();
		System.out.println("FileInputStream不支持mark/reset:"+inputStream.markSupported());
		System.out.println("----------------------------------------");
		
		/*下面介绍一下BufferedInputStream,PushbackInputStream对InputStream的装饰*/
		//1.BufferedInputStream，它提供了mark和reset
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		System.out.println("BufferedInputStream支持mark/reset:"+bis.markSupported());
		//标记一下
		bis.mark(0);
		char c = (char)bis.read();
		System.out.println("第一个字符:"+c);
		//重置一下,如果没有重置，则再次调用read时将读取下一个字符
		bis.reset();
		c = (char)bis.read();
		System.out.println("重置以后在读，依然是第一个字符："+c);
		bis.reset();
		
		System.out.println("----------------------------------------");
		
		//PushbackInputStream无法装饰BufferedInputStream，因为重写了mark和reset
		//文件已读到末尾，重新打开一个文件句柄
		inputStream = new FileInputStream(path);
		PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream,length);
		byte[] b = new byte[length];
		//读完整个流
		pushbackInputStream.read(b);
		System.out.println("unread回退前的内容："+new String(b));
		System.out.println("PushbackInputStream装饰后支持回退操作unread");
		//回退
		pushbackInputStream.unread(b);
		b = new byte[length];
		//如果不回退，文件已读完，没有任何打印
		pushbackInputStream.read(b);
		System.out.println("unread回退后的内容："+new String(b));
		
		System.out.println("----------------------------------------");
		
		/*先将InputStream装饰Reader*/
		//之前已被PushbackInputStream读完，重新打开文件句柄
		inputStream = new FileInputStream(path);
		InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
		System.out.println("InputStreamReader有reader的功能，比如转码："+reader.getEncoding()); 
		
		System.out.println("----------------------------------------");
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		System.out.println("BufferedReader有readLine等功能(读一行)：" + bufferedReader.readLine()); 
		LineNumberReader numberReader = new LineNumberReader(reader);
		System.out.println("当前行号(行号从0开始)："+numberReader.getLineNumber());
	}
}
