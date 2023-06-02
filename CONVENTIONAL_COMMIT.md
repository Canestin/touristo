# Conventional Commit Document

<div style="margin-top: 30px;margin-bottom: 30px;">
<img src="https://raw.githubusercontent.com/Canestin/assets/main/img/conventional_commit_messages.png" alt="Touristo Banner"  height="150">
</div>

This document outlines the conventional commit message format for the React / Spring Boot project with the following directory structure: `/client` and `/server`.

## Commit Message Format

The commit messages in this project should follow the Conventional Commit format. The format consists of a header, an optional body, and an optional footer, all separated by a blank line.

### Header

The header has the following structure:

```
<type>(<scope>): <subject>
```

- **type**: The type of the commit, indicating the nature of the changes. It should be one of the following:
  - `feat`: A new feature
  - `fix`: A bug fix
  - `chore`: Routine tasks, maintenance, or other non-functional changes
  - `docs`: Documentation changes
  - `style`: Code style changes (e.g., formatting)
  - `refactor`: Code changes that neither fix a bug nor add a feature
  - `test`: Adding or modifying tests
- **scope**: The scope of the commit, indicating the affected component, module, or section of the project. It should be one of the following:
  - `client`: Changes related to the React client application
  - `server`: Changes related to the Spring Boot server application
- **subject**: A concise description of the change.

### Body

The body provides additional information about the commit. It should provide context, motivation, and any other relevant details. Each line should be no more than 72 characters.

### Footer

The footer is optional and can contain any additional information related to the commit, such as references to issues or pull requests.

## Examples

Here are a few examples of commit messages using the Conventional Commit format:

```
feat(client): Add user registration functionality

• Implemented user registration form and validation
• Added corresponding API endpoint in the server

Closes #123
```

```
fix(server): Fix null pointer exception in user authentication

• Updated authentication logic to handle null values
• Added unit tests to cover the fix

Fixes #456
```

```
chore(client): Update dependencies

• Updated React to version 17.0.2
• Updated axios to version 0.21.1
• Ran code formatter to ensure consistent styling
```

## Conclusion

Following the Conventional Commit format ensures a standardized and descriptive commit history, making it easier to understand the project's changes and collaborate effectively.
