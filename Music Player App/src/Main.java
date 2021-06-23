import java.util.*;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
	
		Album album = new Album("Album1", "DC");
		
		album.addSong("TNT",4.5);
		album.addSong("highway",3.5);
		album.addSong("dual",2.0);
		albums.add(album);
		
		album = new Album("Album2", "Enimem");
		
		album.addSong("love yourself",4.5);
		album.addSong("lose",3.5);
		album.addSong("not afraid",2.0);
		
		albums.add(album);
		
		LinkedList<Song> playlist_1 = new LinkedList<>();
		
		albums.get(0).addToPlayList("highway", playlist_1);
		albums.get(0).addToPlayList("tutor", playlist_1);
		albums.get(0).addToPlayList("lover", playlist_1);
		
		play(playlist_1);
		

	private static void play(LinkedList<Song> playlist) {
		
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();
		
		if(playlist.size() == 0) {
			System.out.println("this has no song");
			
		}
		else {
			System.out.println("now playing" + listIterator.next().toString());
			printMenu();
		}
		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
				case 0:
					System.out.println("playlist complete");
					quit = true;
					break;
				case 1:
					if(!forward) {
						if(listIterator.hasNext()) {
							listIterator.next();
						}
						foward = true;
					}
					if(listIterator.hasNext()) {
						System.out.println("now playing " + listIterator.next().toString());
					}
					else {
						System.out.println(" no song avalable");
						forward = false;
						
					}
					break;
				case 2:
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("now playing"+listIterator.previous().toString());
						System.out.println("we are the first song");
						forward = false;
					}
					break;
				case 3:
					if(forward) {
						if(listIterator.hasPrevious()) {
							System.out.println("now playing" + listIterator.previous().toString());
							forward = false;
						}
					}
				
					
					
			}
		}
		
	}

	

	private static void printMenu() {
		System.out.println("options");
		System.out.println(" 0 - to quit \n" + "1 - to play next song\n" + "2 - to play previous song\n"
				+ "3 - to replay the current song\n" + "4 - list of all songs \n" + "5 - print all available options\n"
				+ "6 - delete current song");
	}

	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("---------------");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}

