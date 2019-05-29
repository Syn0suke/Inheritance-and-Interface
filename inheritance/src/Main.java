import Character.*;
import Interface.*;
import java.util.ArrayList;
import java.util.Scanner;
	
public class Main {

	private Scanner scanner;
    private ArrayList<BaseCharacter> character;

    private void clear()  {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    private void showAll() {
        clear();
        System.out.println("Simulasi kelompok kemampuan");
        for (int i = 0; i < character.size(); ++i) {
            System.out.println(i + " : " + character.get(i).getName());
        }
        System.out.println("9 : Exit");
        System.out.print("Input : ");
    }

    private void init() {
        character.add(new koki());
        character.add(new supir());
        character.add(new multitalent());
        character.add(new pelukis());
        character.add(new resto());
        character.add(new Kosong());
    }

    public Main() {
        
        String command = null;
        String numbers = null;
        ArrayList<Integer> ids = new ArrayList<>();
        scanner = new Scanner(System.in);
        character = new ArrayList<>();

        init();

        do {
            boolean error = false;

            showAll();
            command = scanner.next();

            if (scanner.hasNextLine()) {
                numbers = scanner.nextLine();
                if (!numbers.isEmpty()) {
                    numbers = numbers.replaceAll("\\s", "");
                    String num[] = numbers.split(",");
                    for (int i = 0; i < num.length; ++i) {
                        try {
                            ids.add(Integer.parseInt(num[i]));
                        } catch (Exception e) {
                            error = true;
                            System.out.println("\"Format: [*nama aksi* *IDKarakter1*,*IDKarakter2*,…,*IDKarakterN*]\"");
                        }
                    }
                }
            }

            if (error) {
                scanner.nextLine();
                continue;
            }

            if (command.equalsIgnoreCase("9")) {
                break;
            }

            if (!command.equalsIgnoreCase("info") && !command.equalsIgnoreCase("cook") &&
                !command.equalsIgnoreCase("paint") && !command.equalsIgnoreCase("drive") &&
                !command.equalsIgnoreCase("work")) {
                System.out.println("Command not available");
            } else if (ids.isEmpty()) {
                System.out.println("Format: [*nama aksi* *IDKarakter1*,*IDKarakter2*,…,*IDKarakterN*]");
            } else {
                if (command.equalsIgnoreCase("info")) {
                    for (int i : ids) {
                        try {
                            character.get(i).getInfo();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Id " + i + " not available");
                        }
                    }
                } else if (command.equalsIgnoreCase("cook")) {
                    for (int i : ids) {
                        if (character.get(i) instanceof IChef) {
                            try {
                                ((IChef) character.get(i)).cook();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Id " + i + " not available");
                            }
                        } else {
                            System.out.println(character.get(i).getName() + " tidak dapat melakukan aksi");
                        }
                    }
                } else if (command.equalsIgnoreCase("drive")) {
                    for (int i : ids) {
                        if (character.get(i) instanceof IDriver) {
                            try {
                                ((IDriver) character.get(i)).drive();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Id " + i + " not available");
                            }
                        } else {
                            System.out.println(character.get(i).getName() + " tidak dapat melakukan aksi");
                        }
                    }
                } else if (command.equalsIgnoreCase("work")) {
                    for (int i : ids) {
                        if (character.get(i) instanceof IWorker) {
                            try {
                                ((IWorker) character.get(i)).work();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Id " + i + " not available");
                            }
                        } else {
                            System.out.println(character.get(i).getName() + " tidak dapat melakukan aksi");
                        }
                    }
                } else if (command.equalsIgnoreCase("paint")) {
                    for (int i : ids) {
                        if (character.get(i) instanceof IArtist) {
                            try {
                                ((IArtist) character.get(i)).paint();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Id " + i + " not available");
                            }
                        } else {
                            System.out.println(character.get(i).getName() + " tidak dapat melakukan aksi");
                        }
                    }
                } else {
                    System.out.println("Command not available");
                }
            }

            scanner.nextLine();
            ids.clear();
        } while (!command.equals("-1"));
    }

    public static void main(String[] args) {
        new Main();
    }
}
