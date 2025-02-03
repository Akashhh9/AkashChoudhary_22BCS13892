package AkashChoudhary_22BCS13892.LabExp;

import java.util.ArrayList;
import java.util.Scanner;

public class VideoRentalSystem {
    static class Video {
        private String title;
        private boolean checkedOut;
        private double averageRating;
        private int ratingCount;
        public Video(String title) {
            this.title = title;
            this.checkedOut = false;
            this.averageRating = 0.0;
            this.ratingCount = 0;
        }
        public void checkOut() {
            if (!checkedOut) {
                checkedOut = true;
                System.out.println(title + " has been checked out.");
            } else {
                System.out.println(title + " is already checked out.");
            }
        }
        public void returnVideo() {
            if (checkedOut) {
                checkedOut = false;
                System.out.println(title + " has been returned.");
            } else {
                System.out.println(title + " was not checked out.");
            }
        }
        public void receiveRating(int rating) {
            if (rating >= 1 && rating <= 5) {
                averageRating = ((averageRating * ratingCount) + rating) / (ratingCount + 1);
                ratingCount++;
                System.out.println("Rating " + rating + " received for " + title);
            } else {
                System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
            }
        }
        @Override
        public String toString() {
            return "Video: " + title + " | Checked Out: " + checkedOut + " | Rating: " + averageRating;
        }
    }
    static class VideoStore {
        private ArrayList<Video> videos;
        public VideoStore() {
            videos = new ArrayList<>();
        }
        public void addVideo(String title) {
            videos.add(new Video(title));
            System.out.println("Video \"" + title + "\" added to inventory.");
        }
        public void checkOut(String title) {
            for (Video video : videos) {
                if (video.title.equalsIgnoreCase(title)) {
                    video.checkOut();
                    return;
                }
            }
            System.out.println("Video \"" + title + "\" not found in inventory.");
        }
        public void returnVideo(String title) {
            for (Video video : videos) {
                if (video.title.equalsIgnoreCase(title)) {
                    video.returnVideo();
                    return;
                }
            }
            System.out.println("Video \"" + title + "\" not found in inventory.");
        }
        public void receiveRating(String title, int rating) {
            for (Video video : videos) {
                if (video.title.equalsIgnoreCase(title)) {
                    video.receiveRating(rating);
                    return;
                }
            }
            System.out.println("Video \"" + title + "\" not found in inventory.");
        }
        public void listInventory() {
            System.out.println("Video Inventory:");
            for (Video video : videos) {
                System.out.println(video);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore store = new VideoStore();
        int choice;

        do {
            System.out.println("\n--- Video Store Menu ---");
            System.out.println("1. Add a Video");
            System.out.println("2. Rent a Video");
            System.out.println("3. Return a Video");
            System.out.println("4. Rate a Video");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the video to add: ");
                    String titleToAdd = scanner.nextLine();
                    store.addVideo(titleToAdd);
                    break;
                case 2:
                    System.out.print("Enter the title of the video to rent: ");
                    String titleToRent = scanner.nextLine();
                    store.checkOut(titleToRent);
                    break;
                case 3:
                    System.out.print("Enter the title of the video to return: ");
                    String titleToReturn = scanner.nextLine();
                    store.returnVideo(titleToReturn);
                    break;
                case 4:
                    System.out.print("Enter the title of the video to rate: ");
                    String titleToRate = scanner.nextLine();
                    System.out.print("Enter the rating (1-5): ");
                    int rating = scanner.nextInt();
                    store.receiveRating(titleToRate, rating);
                    break;
                case 5:
                    store.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting the Video Store. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }
}
