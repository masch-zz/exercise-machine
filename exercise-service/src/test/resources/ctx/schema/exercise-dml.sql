INSERT INTO AUTHOR (ID, NAME, FIRST_NAME, MIDDLE_NAME, LAST_NAME) VALUES 
		    (1, 'Wooton', 'John', NULL, 'Wooton');

/************************************************************************/

INSERT INTO BOOK (ID, AUTHOR_ID, NAME) VALUES 
		    (1, 1, 'Rudimental Remedies');

/************************************************************************/		    

INSERT INTO CHAPTER_BOOK (ID, BOOK_ID, NUMBER, NAME) VALUES 
		    (1, 1, 1, 'Rebound'),
		    (2, 1, 2, 'All Strokes'),
		    (3, 1, 3, 'Single Stroke Rolls');

/************************************************************************/
		    
INSERT INTO LEVEL (ID, NAME) VALUES 
		    (1, 'NIVEL 1'), 
		    (2, 'NIVEL 2'), 
		    (3, 'NIVEL 3'),
		    (4, 'NIVEL 4'),
		    (5, 'NIVEL 5');

/************************************************************************/

INSERT INTO EXERCISE_BASE (ID, POSITION_ORDER, NAME) VALUES
            (1, 1, '1E'),
            (2, 2, '2E'),
            (3, 3, '3E');
            
/************************************************************************/
            
INSERT INTO EXERCISE_LEVEL_BASE (ID, LEVEL_ID, EXERCISE_BASE_ID, VELOCITY) VALUES
            (1, 1, 1, NULL),
            (2, 2, 1, NULL),
            (3, 3, 1, NULL),
            (4, 4, 1, NULL),
            (5, 5, 1, NULL),
            (6, 1, 2, NULL),
            (7, 2, 2, NULL),
            (8, 3, 2, NULL),
            (9, 4, 2, NULL),
            (10, 5, 2, NULL),
            (11, 1, 3, NULL),
            (12, 2, 3, NULL),
            (13, 3, 3, NULL),
            (14, 4, 3, NULL),
            (15, 5, 3, NULL);
            
/************************************************************************/

INSERT INTO EXERC_LEV_CHAP_BOOK (ID, CHAPTER_BOOK_ID, EXERCISE_LEVEL_BASE_ID) VALUES
			(1, 1, 1),
			(2, 1, 2),
			(3, 1, 3),
			(4, 1, 4),
			(5, 1, 5),
			(6, 2, 6),
			(7, 1, 7),
			(8, 1, 8),
			(9, 1, 9),
			(10, 2, 10),
			(11, 2, 11);
			
/************************************************************************/
			
INSERT INTO ROUTINE_BASE (ID, NAME) VALUES
            (1, '1 y 1'),
            (2, 'DIARY ROUTINE');
            
/************************************************************************/

INSERT INTO ROUTINE_BASE_EXERCISE_BASE (ID, ROUTINE_BASE_ID, EXERCISE_LEVEL_BASE_ID, POSITION_ORDER) VALUES
            (1, 1, 2, 2),
            (2, 1, 3, 1),
            (3, 1, 7, 4),
            (4, 1, 6, 3),
            (5, 1, 8, 5),
            (6, 2, 9, 6),
            (7, 2, 11, 7),
            (8, 2, 12, 8),
            (9, 2, 13, 9);
