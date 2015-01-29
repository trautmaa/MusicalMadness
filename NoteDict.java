import java.util.*;

public class NoteDict {
	
	//dictionaries storing note names and sound.midi numbers
	public Map<Integer, String> intKeyNoteDict;
	public Map<String, Integer> strKeyNoteDict;
	public Map<Integer, String> intKeyInstrumentDict;
	public Map<String, Integer> strKeyInstrumentDict;
	
	public NoteDict() {
		//with note integer as key
		intKeyNoteDict = new HashMap<Integer, String>();
		intKeyNoteDict.put(60, "C");
		intKeyNoteDict.put(61, "C#");
		intKeyNoteDict.put(62, "D");
	    intKeyNoteDict.put(63, "D#");
		intKeyNoteDict.put(64, "E");
		intKeyNoteDict.put(65, "F");
		intKeyNoteDict.put(66, "F#");
		intKeyNoteDict.put(67, "G");
		intKeyNoteDict.put(68, "G#");
		intKeyNoteDict.put(69, "A");
		intKeyNoteDict.put(70, "A#");
		intKeyNoteDict.put(71, "B");
		intKeyNoteDict.put(72, "C");
		intKeyNoteDict.put(73, "C#");
		intKeyNoteDict.put(74, "D");
		intKeyNoteDict.put(75, "D#");
		intKeyNoteDict.put(76, "E");
		intKeyNoteDict.put(77, "F");
		intKeyNoteDict.put(78, "F#");
		intKeyNoteDict.put(79, "G");
		intKeyNoteDict.put(80, "G#");
		intKeyNoteDict.put(81, "A");
		intKeyNoteDict.put(82, "A#");
		intKeyNoteDict.put(83, "B");
		intKeyNoteDict.put(84, "C");
		
		//with note string as key
		strKeyNoteDict = new HashMap<String, Integer>();
		strKeyNoteDict.put("C", 60);
		strKeyNoteDict.put("C#", 61);
		strKeyNoteDict.put("D", 62);
		strKeyNoteDict.put("D#", 63);
		strKeyNoteDict.put("E", 64);
		strKeyNoteDict.put("F", 65);
		strKeyNoteDict.put("F#", 66);
		strKeyNoteDict.put("G", 67);
		strKeyNoteDict.put("G#", 68);
		strKeyNoteDict.put("A", 69);
		strKeyNoteDict.put("A#", 70);
		strKeyNoteDict.put("B", 71);
		strKeyNoteDict.put("C", 72);
		strKeyNoteDict.put("C#", 73);
		strKeyNoteDict.put("D", 74);
		strKeyNoteDict.put("D#", 75);
		strKeyNoteDict.put("E", 76);
		strKeyNoteDict.put("F", 77);
		strKeyNoteDict.put("F#", 78);
		strKeyNoteDict.put("G", 79);
		strKeyNoteDict.put("G#", 80);
		strKeyNoteDict.put("A", 81);
		strKeyNoteDict.put("A#", 82);
		strKeyNoteDict.put("B", 83);
		strKeyNoteDict.put("C", 84);
		
		intKeyInstrumentDict = new HashMap<Integer, String>();
		intKeyInstrumentDict.put(0, "Piano");
		intKeyInstrumentDict.put(24, "Guitar");
		intKeyInstrumentDict.put(34, "Electric Bass");
		intKeyInstrumentDict.put(40, "Violin");
		intKeyInstrumentDict.put(65, "Alto Sax");
		intKeyInstrumentDict.put(74, "Recorder");
		intKeyInstrumentDict.put(105, "Banjo");
		intKeyInstrumentDict.put(109, "Bagpipes");
		intKeyInstrumentDict.put(114, "Steel Drum");
		intKeyInstrumentDict.put(127, "Gunshot");
		
		strKeyInstrumentDict = new HashMap<String, Integer>();
		strKeyInstrumentDict.put("Piano", 0);
		strKeyInstrumentDict.put("Guitar", 24);
		strKeyInstrumentDict.put("Electric Bass", 34);
		strKeyInstrumentDict.put("Violin", 40);
		strKeyInstrumentDict.put("Alto Sax", 65);
		strKeyInstrumentDict.put("Recorder", 74);
		strKeyInstrumentDict.put("Banjo", 105);
		strKeyInstrumentDict.put("Bagpipes", 109);
		strKeyInstrumentDict.put("Steel Drum", 114);
		strKeyInstrumentDict.put("Gunshot", 127);
	}
	
	//methods for retrieval
	public String getPitchString(Integer noteNum) {
		String noteName = intKeyNoteDict.get(noteNum);
		return noteName;
	}
	
	public String getRandomNoteString() {
		Random rand = new Random();
		String noteName = intKeyNoteDict.get(rand.nextInt(25) + 60);
		return noteName;
	}
	
	public Integer getPitchInt(String noteName) {
		Integer noteNum = strKeyNoteDict.get(noteName);
		return noteNum;
	}
	
	public Integer getInstrumentInt(String instrumentName) {
		Integer instrumentNum = strKeyInstrumentDict.get(instrumentName);
		return instrumentNum;
	}
	
	public String getRandomInstrumentString() {
		String instrumentName = "Alex";
		Random rand = new Random();
		boolean done = false;
		while (done == false) {
			Integer instrumentNum = rand.nextInt(128);
			if (instrumentNum==0||instrumentNum==24||instrumentNum==34||instrumentNum==40||instrumentNum==65||instrumentNum==74||instrumentNum==105
					||instrumentNum==109||instrumentNum==114||instrumentNum==127) {
				instrumentName = intKeyInstrumentDict.get(instrumentNum);
				done = true;
			}
		}
		return instrumentName;
	}
		
}

