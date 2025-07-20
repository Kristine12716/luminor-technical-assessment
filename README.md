# IMDB Test Automation Project

This project demonstrates automated testing of IMDB website using Selenide, TestNG, and Allure reporting.

## 🚀 Features

- **Page Object Model (POM)** - Maintainable and reusable test structure
- **Allure Reporting** - Beautiful and detailed test reports
- **Parallel Execution** - Faster test execution
- **Screenshot Capture** - Automatic screenshots on test failures
- **Cross-browser Support** - Configurable browser testing
- **Test Data Management** - Centralized test data

## 🛠️ Technology Stack

- **Java 17**
- **Gradle** - Build tool
- **Selenide** - Web testing framework
- **TestNG** - Testing framework
- **Allure** - Test reporting
- **Chrome WebDriver** - Browser automation

## 📁 Project Structure

```
src/test/java/com/imdb/
├── base/
│   └── BaseTest.java              # Base test class
├── config/
│   └── TestConfig.java            # Test configuration
├── data/
│   └── TestData.java              # Test data constants
├── listeners/
│   └── TestListener.java          # Test event listeners
├── pages/
│   ├── HomePage.java              # IMDB homepage
│   ├── SearchResultsPage.java     # Search results page
│   ├── TitlePage.java             # Movie/TV show page
│   └── ProfilePage.java           # Actor/actress profile page
└── ImdbSearchTest.java            # Main test class
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle (or use the wrapper)
- Chrome browser

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd ImdbTechnicalAssesment
   ```

2. **Set up Java**
   ```bash
   export JAVA_HOME=/path/to/your/java17
   ```

3. **Run tests**
   ```bash
   ./gradle-8.14.3/bin/gradle test
   ```

## 🧪 Running Tests

### All Tests
```bash
./gradle-8.14.3/bin/gradle test
```

### Smoke Tests Only
```bash
./gradle-8.14.3/bin/gradle smokeTest
```

### Regression Tests
```bash
./gradle-8.14.3/bin/gradle regressionTest
```

### With Custom Properties
```bash
./gradle-8.14.3/bin/gradle test -Dbrowser=firefox -Dheadless=true
```

## 📊 Test Reports

### TestNG Reports
- Location: `build/reports/tests/test/index.html`
- Contains: Test results, failures, execution time

### Allure Reports
```bash
# Generate Allure report
./gradle-8.14.3/bin/gradle allureReport

# Open Allure report
./gradle-8.14.3/bin/gradle allureServe
```

## ⚙️ Configuration

### Browser Configuration
- Default: Chrome
- Configurable via system properties:
  - `-Dbrowser=firefox`
  - `-DbrowserSize=1920x1080`
  - `-Dheadless=true`

### Test Data
Edit `src/test/java/com/imdb/data/TestData.java` to modify:
- Search queries
- Expected values
- Timeouts
- Browser configurations

## 🔧 Customization

### Adding New Tests
1. Create new test methods in `ImdbSearchTest.java`
2. Add `@Test` annotation with appropriate groups
3. Use existing POM classes or create new ones

### Adding New Pages
1. Create new page class in `pages/` package
2. Extend existing POM pattern
3. Add `@Step` annotations for Allure reporting

### Test Groups
- `smoke` - Critical functionality tests
- `regression` - Full test suite
- `ui` - User interface tests

## 🐛 Troubleshooting

### Common Issues

1. **403 Forbidden Error**
   - IMDB blocks automated access
   - Solution: Updated user agent and Chrome options

2. **Element Not Found**
   - Website structure changed
   - Solution: Update selectors in POM classes

3. **Java Not Found**
   - Set JAVA_HOME environment variable
   - Ensure Java 17 is installed

### Debug Mode
```bash
./gradle-8.14.3/bin/gradle test -Dselenide.headless=false
```

## 📈 Best Practices

1. **Use POM Pattern** - Keep page objects separate from test logic
2. **Add Allure Steps** - Use `@Step` annotations for better reporting
3. **Handle Waits** - Use explicit waits for better reliability
4. **Take Screenshots** - Automatic screenshots on failures
5. **Use Test Groups** - Organize tests by functionality

## 🤝 Contributing

1. Follow the existing code structure
2. Add appropriate test groups
3. Update documentation
4. Ensure all tests pass

## 📝 License

This project is for educational and demonstration purposes. 