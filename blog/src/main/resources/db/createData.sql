delete from Blog;
insert into Blog (id,title,publishedDate,category,author,likes,content) values
(NEXT VALUE FOR blog_seq,'Evan sala, la sua moto fa pena?', '2025-1-21', 'Motori', 'Mitch', 100, 'tutti si chiedono, ma evan non risponde'),
(NEXT VALUE FOR blog_seq,'Michele cate, la sua moto è pazzurda', '2025-1-22', 'Motori', 'Evan', 1000000, 'evan sputa fatti.');

