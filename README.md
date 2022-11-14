# coding-events
susans coding events practice

#purpose of the app
This application tracks events around different locations and offers details about them. 

#current state of the app. 
The user is able to add events to the application and attach tags to the events.

#future improvements
We need to include a Person class in order to have our users to select and save their favorite events.

#Proposed architecture
Fields:
- Name - String
- Email - String
- Password - String
- List of Events - List<Event> : Many to Many
- FavoriteCategory - EventCategory : Many to One (Person can only have One favorite category)

Methods:
- Getters andSetters
- Get back Favorite Events (returns all events that have to do with their favorite category)
