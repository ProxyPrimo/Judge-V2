# Judge V2

Judge V2 is a grading system, which users can use Github 
repositories to add their solutions to various problems
that Admins can add.

## The Stack

**Front-End:**

*   HTML
*   CSS
*   Bootstrap
*   Thymeleaf


**Back-End:**
*   Java
*   Spring Boot
*   Spring MVC
*   MySQL

## The Functionalities

**Anonymous** users have access to :

- The Index Page
- The Login Page
- The Registration Form

**Authenticated** users have access to :

- The Home Page
- Their Profile Page
- The "Add Homework" Page
- The "Check Homework" Page

**Administrators** have access to :

- The pages, which the authenticated users have access to
- The page for changing the role of the users
- The "Add Exercise" Page

## The Routes

URLs | Description
---------|---------
*/* | The Index Page
*/users/register* | The Registration Page
*/users/login* | The Login Page 
*/users/profile/{id}* | The User Profile page
*/roles/change* | The page for changing the user roles
*/homeworks/add* | The Add Homeworks Page
*/homeworks/check* | The Homework Grading Page