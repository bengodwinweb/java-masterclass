import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> indexes = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    // 1. The first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 byes long. It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700

    static {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");

        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

//        System.out.println("Locations size: " + locations.size());
//        try {
//            BufferedReader locFile = new BufferedReader(new FileReader("locations.txt"));
//            BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"));
//
//            String input;
//            while((input = locFile.readLine()) != null) {
//                    String[] data = input.split(",");
//                    int locationId = Integer.parseInt(data[0]);
//                    String description = data[1];
//                    Location location = new Location(locationId, description, null);
//                    locations.put(locationId, location);
//            }
//
//            input = null;
//            while((input = dirFile.readLine()) != null) {
//                    String[] data = input.split(",");
//                    int locationId = Integer.parseInt(data[0]);
//                    String direction = data[1];
//                    int nextLocation = Integer.parseInt(data[2]);
//                    locations.get(locationId).addExit(direction, nextLocation);
//            }
//        } catch(IOException e) {
//            e.getMessage();
//        }
//
//        System.out.println("Locations size: " + locations.size());
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = indexes.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String desription = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, desription, null);
        if(locationId != 0) {
            for(int i = 0; i < exitPart.length; i++) {
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException {
        ra.close();
    }
}
