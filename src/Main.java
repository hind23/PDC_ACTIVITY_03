import java.util.Scanner;

// target
interface Exportable {
    void export(String data);
}

// PDF Export Adapter
class PDFExportAdapter implements Exportable {
    private PDFExporter pdfExporter;

    public PDFExportAdapter() {
        this.pdfExporter = new PDFExporter();
    }

    @Override
    public void export(String data) {
        pdfExporter.generatePDF(data);
    }
}

// CSV Export Adapter
class CSVExportAdapter implements Exportable {
    private CSVExporter csvExporter;

    public CSVExportAdapter() {
        this.csvExporter = new CSVExporter();
    }

    @Override
    public void export(String data) {
        csvExporter.generateCSV(data);
    }
}

// HTML Export Adapter
class HTMLExportAdapter implements Exportable {
    private HTMLExporter htmlExporter;

    public HTMLExportAdapter() {
        this.htmlExporter = new HTMLExporter();
    }

    @Override
    public void export(String data) {
        htmlExporter.generateHTML(data);
    }
}

// adaptee PDF
class PDFExporter {
    public void generatePDF(String data) {
        System.out.println("Exporting data to PDF: " + data);
    }
}

// adaptee CSV
class CSVExporter {
    public void generateCSV(String data) {
        System.out.println("Exporting data to CSV: " + data);
    }
}

// adaptee HTML
class HTMLExporter {
    public void generateHTML(String data) {
        System.out.println("Exporting data to HTML: " + data);
    }
}

// THE CLIENT
class ExportManager {
    private Exportable exportType;

    public void setExportType(Exportable exportType) {
        this.exportType = exportType;
    }

    public void exportData(String data) {
        exportType.export(data);
    }
}



public class Main {
    public static void main(String[] args) {
        ExportManager exportManager = new ExportManager();
        String data = "Notion Page Content";

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose export format:");
            System.out.println("1. PDF");
            System.out.println("2. CSV");
            System.out.println("3. HTML");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exportManager.setExportType(new PDFExportAdapter());
                    System.out.println("Exporting as PDF");
                    exportManager.exportData(data);
                    break;
                case 2:
                    exportManager.setExportType(new CSVExportAdapter());
                    System.out.println("Exporting as CSV");
                    exportManager.exportData(data);
                    break;
                case 3:
                    exportManager.setExportType(new HTMLExportAdapter());
                    System.out.println("Exporting as HTML");
                    exportManager.exportData(data);
                    break;
                case 0:
                    System.out.println("THANK YOU!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}