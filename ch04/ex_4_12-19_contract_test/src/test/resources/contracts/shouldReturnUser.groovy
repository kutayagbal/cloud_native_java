package contracts

org.springframework.cloud.contract.spec.Contract.make{
	request{
		method 'GET'
		url	'/user/getuser'
		headers{
			header('Content-Type': consumer(regex('application/*json*')))
		}
	}
	
	response {
		status 200
		body([
			id			:	value(producer(regex('[0-9]+'))),
			username	:	value(producer(regex('[A-Za-z0-9]+'))),
			password	:	value(producer(regex('[A-Za-z0-9]+'))),
			email		:	value(producer(regex('[A-Za-z0-9]+\\@[A-Za-z0-9]+\\.[A-Za-z]+')))
			])
		headers{
			header('Content-Type': value(
				producer('application/json;charset=UTF-8'),
				consumer('application/json;charset=UTF-8'))
			)
		}
	}
}