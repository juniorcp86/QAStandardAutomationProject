General description:
Automation projects on Blanclabs QA team use selenium web driver as main option with maven repositories and test ng framework.

This structure is to be used like standard for begin any automation project for Blanclabs QA team.

General behaviour:
1. Create and uses .gitignore file to saved specific directories or file that should not be on repository. But those files must be on local project. General suggestion is related to browser drivers, because those are different for operative system.
2. On directory "src/java/scenarios/" must be created any modules as your project (system, web page, application, etc.) have. For example, should be apply for macro menu options like profile, statements, etc. Those are options that have several sub-options.
3. On directory "src/java/utils/" must be created modules (in case apply) or classes that have one or more functions used several times on test cases. For example, signIn() must be used on every test case that is related with process after user log in.
4. On directory "src/evidences/" must be saved every screen shot taken during test cases execution. The content of this directory must not be on the repository.
5. Log4j used to write logs on needed levels. Make sure log4j.properties have proper format and information to generate additional value to find errors.
6. General properties, used to define global values that are use several times on test cases. For example, URL for environment, email account credentials.
7. Front end components, used to manage HTML id's and identify object for every page. 
8. On directory "src/drivers/" must be executable for every browser automation project need to create instances on test cases.

Recommendations for comments on classes:
/**
 * Creation Date: DD/MM/YYYY
 * Created By: Created by @<QA_Name>.
 * Description: <Main_goal_of_class>.
 */
 
 Recommendations for comments on every function:
 /**
 * Name: <functioName>()
 * Creation Date: DD/MM/YYYY
 * Description: <Main_goal_of_this function>.
 * It has one argument:
 * 1. <firstArgument>: <For_what_is_made_or_used_the_value_received>.
 * */