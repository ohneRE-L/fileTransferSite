## ✨ Overview

`fileTransferSite` is a **lightweight and secure** web application built with Spring Boot, designed for simple and ephemeral file sharing. It allows users to effortlessly upload files and receive a unique, shareable download link. With features like optional expiration times and automatic cleanup, it's perfect for quickly sharing files that don't need to persist indefinitely. The application focuses on a streamlined user experience, providing direct links and QR codes for convenience.

## 🚀 Key Features

*   **📤 Easy File Uploads**: Upload any file through a simple web interface.
*   **🔗 Unique Download Links**: Generates a unique UUID-based link for each uploaded file, ensuring privacy and direct access.
*   **⏳ Configurable Expiration**: Set an optional expiration time (in minutes) for files, after which they are automatically deleted.
*   **🧹 Automated Cleanup**: A background task periodically cleans up all expired files, maintaining data hygiene.
*   **📱 QR Code Generation**: Upon upload, a QR code is generated for the download link, making it easy to share across devices.
*   **💾 In-Memory Storage**: Utilizes an H2 in-memory database for quick setup and ephemeral storage, ideal for development or temporary sharing.
*   **📏 Customizable File Size**: Default max file size of 10MB, easily configurable via `application.properties`.

---

## 💻 Getting Started

Follow these steps to get `fileTransferSite` up and running on your local machine for development and testing.

### Prerequisites

Ensure you have the following essential software installed on your system:

*   **Java Development Kit (JDK)**: `Version 17` or higher
    *   [Download JDK](https://www.oracle.com/java/technologies/downloads/) (or use OpenJDK)
*   **Apache Maven**: `Version 3.x` or higher (usually bundled with IDEs or available via package managers)

### Installation

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/ohneRE-L/fileTransferSite.git
    cd fileTransferSite
    ```

2.  **Build the project using Maven**:
    ```bash
    ./mvnw clean install
    # On Windows: .\mvnw.cmd clean install
    ```
    This command will download dependencies and compile the project.

3.  **📝 Configure Environment Variables (Optional)**:
    While `fileTransferSite` uses an in-memory H2 database by default (so no external setup is strictly needed), you can configure aspects like file size limits in `src/main/resources/application.properties`.

    ```properties
    # src/main/resources/application.properties
    spring.application.name=fileTransferSite
    spring.servlet.multipart.max-file-size=10MB # Adjust as needed
    spring.servlet.multipart.max-request-size=10MB # Adjust as needed
    # ... other H2 database settings already present
    ```

### Running the Application

To launch `fileTransferSite`:

```bash
./mvnw spring-boot:run
# On Windows: .\mvnw.cmd spring-boot:run
```

Once started, the application will be accessible in your web browser at `http://localhost:8080`.
Open your browser and navigate to this address to start uploading files!

---

## 🛠️ Technologies & Tools

This project leverages a modern and robust tech stack to deliver its functionality:

*   **Backend Framework**:
    *   <img alt="Spring Boot" src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
    *   <img alt="Spring Web" src="https://img.shields.io/badge/Spring_Web-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    *   <img alt="Spring Data JPA" src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
*   **Runtime**:
    *   <img alt="Java" src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
*   **Database**:
    *   <img alt="H2 Database" src="https://img.shields.io/badge/H2_Database-000000?style=for-the-badge&logo=h2&logoColor=white"/> (In-memory)
*   **Build Tool**:
    *   <img alt="Maven" src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
*   **Helper Libraries**:
    *   <img alt="Lombok" src="https://img.shields.io/badge/Lombok-F752B3?style=for-the-badge&logo=lombok&logoColor=white"/> (For boilerplate code reduction)
*   **Frontend**:
    *   <img alt="HTML5" src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/>
    *   <img alt="CSS3" src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
    *   <img alt="JavaScript" src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"/>
    *   [QR Code JS](https://github.com/davidshimjs/qrcodejs)

---

## 🤝 Contributing

We welcome and appreciate contributions to `fileTransferSite`! Your input helps make this project better for everyone. If you have an idea, a bug report, or a feature request, please don't hesitate to open an issue or submit a pull request.

1.  **Fork the Project**: Click the "Fork" button at the top right of this repository.
2.  **Create your Feature Branch**:
    ```bash
    git checkout -b feature/AmazingFeature
    ```
    *(e.g., `feature/add-dark-mode` or `fix/upload-bug`)*
3.  **Commit your Changes**:
    ```bash
    git commit -m 'feat: Add some AmazingFeature' # Use conventional commits if possible
    ```
4.  **Push to the Branch**:
    ```bash
    git push origin feature/AmazingFeature
    ```
5.  **Open a Pull Request**: Explain your changes thoroughly and link to any relevant issues.

Don't forget to give the project a ⭐ star! Thanks for your contribution!

---

### Acknowledgements

*   [Shields.io](https://shields.io/) for the amazing badges.
*   [QR Code JS](https://github.com/davidshimjs/qrcodejs) for the client-side QR code generation.
*   [Lombok](https://projectlombok.org/) for simplifying Java boilerplate.
*   [Spring Boot](https://spring.io/projects/spring-boot) community for the excellent framework.

---