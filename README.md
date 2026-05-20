# Secure Password Checker - Java

A beginner-friendly Java command-line tool that checks password strength and gives clear security recommendations.

This project is part of my journey toward becoming a **Secure AI Engineer** by building practical software with a cybersecurity mindset.

---

## Repository Description

**Short GitHub description:**

> Java CLI tool for checking password strength while practicing secure coding, input validation, and cybersecurity fundamentals.

**Recommended visibility:** Public

**Recommended topics:**

```text
java cybersecurity secure-coding password-security cli-tool beginner-project owasp student-project
```

---

## Features

- Checks password length
- Detects uppercase letters, lowercase letters, numbers, and symbols
- Detects common weak passwords
- Gives a strength rating: `WEAK`, `MODERATE`, or `STRONG`
- Provides improvement suggestions
- Does not store, log, or transmit passwords
- Includes beginner-friendly Java code and unit tests

---

## Tech Stack

- Java 17+
- Maven
- JUnit 5 for tests
- IntelliJ IDEA or VS Code

---

## Project Structure

```text
secure-password-checker-java/
├── src/
│   ├── main/java/com/mrhays/security/passwordchecker/
│   │   ├── App.java
│   │   ├── PasswordAnalysis.java
│   │   ├── PasswordRating.java
│   │   └── PasswordStrengthChecker.java
│   └── test/java/com/mrhays/security/passwordchecker/
│       └── PasswordStrengthCheckerTest.java
├── docs/
│   └── ROADMAP.md
├── .github/
│   ├── ISSUE_TEMPLATE/
│   │   ├── bug_report.md
│   │   └── feature_request.md
│   ├── PULL_REQUEST_TEMPLATE.md
│   └── workflows/
│       └── java-ci.yml
├── .gitignore
├── CHANGELOG.md
├── CONTRIBUTING.md
├── LICENSE
├── pom.xml
├── README.md
└── SECURITY.md
```

---

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/Mrhays007/secure-password-checker-java.git
cd secure-password-checker-java
```

### 2. Run tests

```bash
mvn test
```

### 3. Build the project

```bash
mvn clean package
```

### 4. Run the app

```bash
mvn exec:java
```

Alternatively, open the project in IntelliJ IDEA and run `App.java`.

---

## Example Output

```text
====================================
 Secure Password Checker - Java
====================================
Enter a password to analyze: ********

Rating: STRONG
Score: 90/100

Positive checks:
- Good length
- Contains uppercase letters
- Contains lowercase letters
- Contains numbers
- Contains symbols

Suggestions:
- No major issues found. Keep using unique passwords for every account.
```

---

## Security Notes

This is an educational project and is not intended to be used as a production password manager or authentication system.

Security-conscious practices included:

- Passwords are not saved to files
- Passwords are not printed back to the terminal
- Password analysis happens locally
- Common weak passwords are rejected
- Input is validated before analysis

Future improvements:

- Add password entropy estimation
- Add larger common-password blocklist support
- Add password breach-checking concept notes without sending passwords directly
- Add GUI or web version later

---

## What I Learned

Through this project, I am practicing:

- Java classes and methods
- Input validation
- Basic security thinking
- Clean project structure
- Writing technical documentation
- Writing unit tests
- Using GitHub issues and pull requests professionally

---

## Roadmap

See [`docs/ROADMAP.md`](docs/ROADMAP.md).

---

## Continuous Integration

This repository includes a GitHub Actions workflow that runs `mvn test` on every push or pull request to `main`.

---

## License

This project is licensed under the MIT License. See [`LICENSE`](LICENSE) for details.
