package companies.amazon.amazonfullfilment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class CountRepeatVisitors {

	interface LogEntry {
		String getDate();

		String getCustomerId();
	}

	/*
	 * Complete the function.
	 */
	static int countRepeatVisitors(List<LogEntry> logEntries) {
		if (logEntries == null) {
			return 0;
		}
		HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();
		for (LogEntry logEntry : logEntries) {
			if (map.containsKey(logEntry.getCustomerId())) {
				HashSet<String> value = (HashSet<String>) map.get(logEntry
						.getCustomerId());
				value.add(logEntry.getDate());
				map.put(logEntry.getCustomerId(), value);
			} else {
				HashSet<String> value = new HashSet<String>();
				value.add(logEntry.getDate());
				map.put(logEntry.getCustomerId(), value);
			}
		}

		int usrCount = 0;
		for (Entry<String, Set<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				usrCount++;
			}
		}

		return usrCount;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;

		int _logEntries_size = 0;
		_logEntries_size = Integer.parseInt(in.nextLine());
		final List<LogEntry> _logEntries = new ArrayList<>(_logEntries_size);
		String _logEntries_item;
		for (int _logEntries_i = 0; _logEntries_i < _logEntries_size; _logEntries_i++) {
			try {
				_logEntries_item = in.nextLine();
			} catch (Exception e) {
				_logEntries_item = null;
				continue;
			}
			LogEntry newLogEntry = createLogEntry(_logEntries_item);
			if (newLogEntry != null) {
				_logEntries.add(newLogEntry);
			}
		}

		res = countRepeatVisitors(_logEntries);
		System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();
		//
		// bw.close();
	}

	private static LogEntry createLogEntry(String line) {
		final String[] split = line.split(" ");
		if (split.length != 2) {
			return null;
		}
		return new LogEntry() {
			@Override
			public String getDate() {
				return split[0];
			}

			@Override
			public String getCustomerId() {
				return split[1];
			}
		};
	}
}