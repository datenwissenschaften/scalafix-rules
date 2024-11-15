
# 🚀 Scalafix Rules for Data Analytics and Spark Scala

This collection provides specialized Scalafix rules designed to enhance code quality, enforce consistency, and streamline development in projects using **Spark Scala**. 
These rules are built to make Spark and data processing code more robust, readable, and aligned with best practices.

## 🌟 Overview

Scalafix is a powerful refactoring and linting tool for Scala, and with the unique demands of data analytics and Spark applications, 
these custom rules address specific patterns and pitfalls that come with large-scale data processing. 
This repository provides a set of reusable, customizable rules that can be integrated into your CI/CD pipeline, 
ensuring that your Spark-based data solutions are consistently high-quality.

## ✨ Features

- **Code Consistency**: 📏 Enforce code conventions tailored to Spark and analytics projects, keeping your team’s codebase clean and uniform.
- **Customizable Rules**: ⚙️ Adapt rules to fit specific project needs, with a modular setup that allows for easy customization.

## 🚀 Getting Started

### Prerequisites

- **Scala** 2.12
- **Scalafix** 0.9.0 or higher

### Installation

To include these rules in your project, add the following dependency to your `build.sbt`:

```scala
resolvers += "Nexus Maven Releases" at "https://nexus.datenwissenschaften.com/repository/maven-releases/"
ThisBuild / scalafixDependencies += "com.datenwissenschaften" %% "scalafix-rules" % "1.1.1"
```

After adding the dependency, you can run Scalafix directly in your SBT project with:

```bash
sbt scalafix
```

### Configuring Rules

Each rule can be enabled or disabled in the `.scalafix.conf` file. Here’s a sample configuration:

```hocon
rules = [
  "RemoveScalaDoc",
  "SingleLineNestedExpressions"
]
```

Refer to the [docs](docs/RULES.md) for a full list of available rules and configuration options.

## 🤝 Contributing

Contributions are welcome! If you have improvements or additional features in mind, please feel free to open a pull request.

## 📜 License

This project is licensed under the Apache License 2.0. For more information, see the [LICENSE](LICENSE) file.

---

✨ Keep your Scala code clean, consistent, and up-to-date with **datenwissenschaften/scalafix-rules**! 🚀
