import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();
                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i=0; i<10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        try(FileOutputStream binFile = new FileOutputStream("data.dat");
//            FileChannel binChannel = binFile.getChannel())
//        {
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            long outputBytes2Pos = outputBytes.length + 2 * Integer.BYTES;
//            long int1Pos = outputBytes.length;
//            long int2Pos = int1Pos + Integer.BYTES;
//            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(int3Pos);
//            binChannel.write(intBuffer);
//            intBuffer.flip();
//
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(int2Pos);
//            binChannel.write(intBuffer);
//            intBuffer.flip();
//
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(int1Pos);
//            binChannel.write(intBuffer);
//
//            binChannel.position(outputBytes2Pos);
//            binChannel.write(ByteBuffer.wrap(outputBytes2));
//
//            binChannel.position(0);
//            binChannel.write(ByteBuffer.wrap(outputBytes));
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            byte[] inputString = new byte[outputBytes.length];
//            byte[] inputString2 = new byte[outputBytes2.length];
//            int int1, int2, int3;
//
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            ByteBuffer input1Buffer = ByteBuffer.allocate(outputBytes.length);
//            ByteBuffer input2Buffer = ByteBuffer.allocate(outputBytes2.length);
//
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            int3 = readBuffer.getInt();
//
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            int2 = readBuffer.getInt();
//
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            int1 = readBuffer.getInt();
//
//            channel.position(outputBytes2Pos);
//            channel.read(input2Buffer);
//            input2Buffer.flip();
//            input2Buffer.get(inputString2);
//
//            channel.position(0);
//            channel.read(input1Buffer);
//            input1Buffer.flip();
//            input1Buffer.get(inputString);
//
//
//            System.out.println("int1 = " + int1);
//            System.out.println("int2 = " + int2);
//            System.out.println("int3 = " + int3);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("inputString = " + new String(inputString));
//
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rwd");
//            FileChannel copyChannel = copyFile.getChannel();
//            long numTransferred = copyChannel.transferFrom(channel.position(0), 0, channel.size());
//            System.out.println("numTransferred = " + numTransferred);
//
//            channel.close();
//            ra.close();
//            copyChannel.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
