package id.swarawan.service

import id.swarawan.ProfileGrpc
import id.swarawan.UserDetailsRequest
import id.swarawan.UserDetailsResponse
import id.swarawan.repository.ProfileRepository
import io.grpc.Status
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired

@GrpcService
class ProfileService @Autowired constructor(
	private val profileRepository: ProfileRepository
) : ProfileGrpc.ProfileImplBase() {

	override fun getUserDetails(request: UserDetailsRequest, responseObserver: StreamObserver<UserDetailsResponse>) {
		val userDetails = profileRepository.findDetailsById(request.id)
		when {
			userDetails == null -> responseObserver.onError(
				Status.NOT_FOUND
					.withDescription("User not found")
					.asRuntimeException()
			)

			else -> {
				val userDetailResponse = UserDetailsResponse.newBuilder()
				with(userDetailResponse) {
					name = userDetails.name
					email = userDetails.email
					address = userDetails.address
					image = userDetails.image
				}
				responseObserver.onNext(userDetailResponse.build())
			}
		}
		responseObserver.onCompleted()
	}
}