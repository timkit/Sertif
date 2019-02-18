package application;

import java.nio.file.*;
import java.util.stream.Stream;

import static java.nio.file.StandardWatchEventKinds.*;
public class FO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// .. это папка выше т.е. home
		Path dirpath = Paths.get("../Apps");
		System.out.println(dirpath);

		if (!Files.exists(dirpath)) {
			Files.createDirectories(dirpath);
		}
		WatchService watchServise = FileSystems.getDefault().newWatchService();
		dirpath.register(watchServise, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
		for (;;) {
			WatchKey key;
			try {
				key = watchServise.take();
			} catch (Throwable cause) {
				cause.printStackTrace();
				return;
				// TODO: handle exception
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind() == ENTRY_CREATE) {
					Path filePath = ((WatchEvent<Path>) event).context();
					System.out.println("New file '" + filePath + "' was discovered");
					System.out.println("Processing...");
					long time0 = System.currentTimeMillis();
					try {
						Stream<String> stream = Files.lines(filePath);
						stream.forEach(System.out::println);
						stream.close();

					} catch (Throwable e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					System.out.println("File " + filePath + " was successfuly processed in "
							+ (System.currentTimeMillis() - time0) + " ms");
				} else if(event.kind() == ENTRY_MODIFY) {
					System.out.println("File "+((WatchEvent<Path>) event).context()+" was modifed");
				}else if(event.kind() == ENTRY_DELETE) {
					System.out.println("File "+((WatchEvent<Path>) event).context()+" was deleted");
				}else {
					System.out.println("Unsupported event kind");
				}
			}
			if(!key.reset()) {
				break;				
			}
		}
	}

}
