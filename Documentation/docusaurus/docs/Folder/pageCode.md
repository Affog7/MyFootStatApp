---
sidebar_position: 5
title: Page with code samples
description : How to insert code snippets?
---

# How to insert code snippets?

You can insert code snippets by using the following notation:

```
    ```
    My code snippet
    ``` 
```

giving this:
```
My code snippet
``` 

You can also specify the language, like that:

```
    ```csharp
    using System;

    namespace SampleNamespace
    {
        public class MyClass
        {
            public void DoNothing()
            {
                Console.WriteLine("Do nothing");
            }
        }
    }
    ```
```

giving this:
```csharp
using System;

namespace SampleNamespace
{
    public class MyClass
    {
        public void DoNothing()
        {
            Console.WriteLine("Do nothing");
        }
    }
}
```

other sample in python:
```python
class Player:

    _name = ""

    def _get_name(self):
        return self._name
    
    def _set_name(self, name):
        if name.isspace() or (not name) :
            self._name = "Jane Doe"
        else :
            self._name = name

    ## name of this Player
    name = property(_get_name, _set_name)
   
    _id = 0

    def _get_id(self):
        return self._id

    def _set_id(self, id):
        if id <= 0:
            raise Exception("id can not be equal or inferior to 0")
        self._id = id

    ## id of this Player (read only)
    id = property(_get_id)


    ## initializer
    #  @param name the name of this Player (can not be null, empty or white spaces, otherwise, it will be changed to Jane Doe)
    #  @param id the id of this Player (can not be less or equal to 0)
    #  @return an instance of the Player class initialized with the specified name and id.
    def __init__(self, name, id):
        self.name = name
        self._set_id(id)
```