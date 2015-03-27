//
//  ToDoItem.h
//  Todolist
//
//  Created by Adnan Karamat on 12/02/15.
//  Copyright (c) 2015 Adnan Karamat. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ToDoItem : NSObject

@property NSString *itemName;
@property BOOL *completed;
@property (readonly) NSDate *creationDate;


@end
