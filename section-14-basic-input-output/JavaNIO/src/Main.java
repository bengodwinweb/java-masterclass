import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel())
        {
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            long outputBytes2Pos = outputBytes.length + 2 * Integer.BYTES;
            long int1Pos = outputBytes.length;
            long int2Pos = int1Pos + Integer.BYTES;
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);

            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(int3Pos);
            binChannel.write(intBuffer);
            intBuffer.flip();

            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(int2Pos);
            binChannel.write(intBuffer);
            intBuffer.flip();

            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(int1Pos);
            binChannel.write(intBuffer);

            binChannel.position(outputBytes2Pos);
            binChannel.write(ByteBuffer.wrap(outputBytes2));

            binChannel.position(0);
            binChannel.write(ByteBuffer.wrap(outputBytes));

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            byte[] inputString = new byte[outputBytes.length];
            byte[] inputString2 = new byte[outputBytes2.length];
            int int1, int2, int3;


            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            ByteBuffer input1Buffer = ByteBuffer.allocate(outputBytes.length);
            ByteBuffer input2Buffer = ByteBuffer.allocate(outputBytes2.length);

            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            int3 = readBuffer.getInt();

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            int2 = readBuffer.getInt();

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            int1 = readBuffer.getInt();

            channel.position(outputBytes2Pos);
            channel.read(input2Buffer);
            input2Buffer.flip();
            input2Buffer.get(inputString2);

            channel.position(0);
            channel.read(input1Buffer);
            input1Buffer.flip();
            input1Buffer.get(inputString);


            System.out.println("int1 = " + int1);
            System.out.println("int2 = " + int2);
            System.out.println("int3 = " + int3);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("inputString = " + new String(inputString));
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
