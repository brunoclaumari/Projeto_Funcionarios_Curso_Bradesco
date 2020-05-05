USE [sistema_de_funcionarios]
GO

UPDATE [dbo].[funcionarios]
   SET [nome] = <nome, varchar(50),>
      ,[sobrenome] = <sobrenome, varchar(50),>
      ,[dataNascimento] = <dataNascimento, datetime,>
      ,[email] = <email, varchar(60),>
      ,[cargo] = <cargo, int,>
      ,[salario] = <salario, money,>
 WHERE <Search Conditions,,>
GO


